package pl.coderslab.charity.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.coderslab.charity.entity.Role;
import pl.coderslab.charity.entity.User;
import pl.coderslab.charity.repository.RoleRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoleService {

    private final RoleRepository roleRepository;

    public void saveRole(Role role){
        roleRepository.save(role);
    }

    public Role findByName(String name){
        return roleRepository.findByName(name);
    }

    public List<Role> findByUsers(User user){
        return roleRepository.findByUsers(user);
    }

}
