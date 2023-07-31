package pl.coderslab.charity.service;

import jakarta.validation.ValidationException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.charity.entity.Donation;
import pl.coderslab.charity.entity.Role;
import pl.coderslab.charity.entity.User;
import pl.coderslab.charity.repository.DonationRepository;
import pl.coderslab.charity.repository.RoleRepository;
import pl.coderslab.charity.repository.UserRepository;
import jakarta.validation.Valid;

import java.util.*;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final BCryptPasswordEncoder passwordEncoder;

    private final RoleRepository roleRepository;

    private final DonationRepository donationRepository;




    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username).orElseThrow(
                () -> new UsernameNotFoundException(username));
    }

    @Override
    public void saveUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setEnabled(1);
        Role userRole = roleRepository.findByName("ROLE_USER");
        user.setRoles(new HashSet<>(Arrays.asList(userRole)));
        userRepository.save(user);
    }

    @Override
    public void saveAdmin(User admin) {
        admin.setPassword(passwordEncoder.encode(admin.getPassword()));
        admin.setEnabled(1);
        Role userRole = roleRepository.findByName("ROLE_ADMIN");
        admin.setRoles(new HashSet<>(Arrays.asList(userRole)));
        userRepository.save(admin);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public List<User> findByRole(Role role) {
        return userRepository.findByRoles(role);
    }

    @Override
    public void updateUser(User user) {
            userRepository.updateUser(user.getUsername(), user.getName(), user.getSurname(), user.getId());

            Collection<SimpleGrantedAuthority> nowAuthorities =
                    (Collection<SimpleGrantedAuthority>) SecurityContextHolder.getContext()
                            .getAuthentication()
                            .getAuthorities();

            UsernamePasswordAuthenticationToken authentication =
                    new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword(), nowAuthorities);
            SecurityContextHolder.getContext().setAuthentication(authentication);

    }

    @Override
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(
                () -> new NoSuchElementException("Not found user with this ID"));
    }

    @Override
    public void blockUserById(Long id) {
        userRepository.blockUserById(id);
    }

    @Override
    public void unblockUserById(Long id) {
        userRepository.unblockUserById(id);
    }

    @Override
    public void blockOrUnblockUser(User user) {
        if (user.getEnabled() == 1){
            blockUserById(user.getId());
        } else {
            unblockUserById(user.getId());
        }
    }

    @Override
    @Transactional
    public void deleteUserByIdWithRelations(User user) {
        List<Role> rolesWithUser = roleRepository.findByUsers(user);
        for (Role role : rolesWithUser) {
            role.getUsers().remove(user);
            roleRepository.save(role);
        }

        List<Donation> donations = donationRepository.findByUser(user);
        if (!donations.isEmpty()) {
            for (Donation donation : donations) {
                donation.setUser(null);
                donationRepository.save(donation);
            }
        }

        deleteById(user.getId());

    }






}
