package pl.coderslab.charity.service;

import pl.coderslab.charity.entity.Role;
import pl.coderslab.charity.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    Optional<User> findByUsername(String username);

    void saveUser(User user);

    void saveAdmin(User admin);

    List<User> findAll();

    List<User> findByRole(Role role);

    void updateUser(User user);

    void deleteUserByIdWithRelations(User user);

    void deleteById(Long id);

    Optional<User> findById(Long id);

    void blockUserById(Long id);

    void unblockUserById(Long id);

    void blockOrUnblockUser(User user);

}
