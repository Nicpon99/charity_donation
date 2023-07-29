package pl.coderslab.charity.service;

import pl.coderslab.charity.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    Optional<User> findByUsername(String username);

    void saveUser(User user);

    void saveAdmin(User admin);

    List<User> findAll();

}
