package pl.coderslab.charity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.charity.entity.Role;
import pl.coderslab.charity.entity.User;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String username);

    List<User> findByRoles(Role role);

    @Modifying
    @Transactional
    @Query("UPDATE User u SET u.username = ?1, u.name = ?2, u.surname = ?3 WHERE u.id = ?4")
    void updateUser(String username, String name, String surname, Long id);

    @Modifying
    @Transactional
    @Query("UPDATE User u SET u.enabled = 0 WHERE u.id = ?1")
    void blockUserById(Long id);

    @Modifying
    @Transactional
    @Query("UPDATE User u SET u.enabled = 1 WHERE u.id = ?1")
    void unblockUserById(Long id);

}
