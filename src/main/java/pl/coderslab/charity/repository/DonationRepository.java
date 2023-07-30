package pl.coderslab.charity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.charity.entity.Donation;
import pl.coderslab.charity.entity.User;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface DonationRepository extends JpaRepository<Donation, Long> {

    @Query("SELECT SUM(d.quantity) FROM Donation d")
    Optional<Long> getSumOfQuantity();

    @Query("SELECT COUNT(d) FROM Donation d")
    Optional<Long> getSumOfDonations();

    List<Donation> findByUser(User user);

    @Query("SELECT d FROM Donation d WHERE d.user = ?1 ORDER BY d.pickUpStatus DESC, d.pickUpConfirmed DESC, d.created DESC")
    List<Donation> findAllByUserSorted(User user);

    @Modifying
    @Transactional
    @Query("UPDATE Donation d SET d.pickUpStatus = 'odebrany', d.pickUpConfirmed = ?1 WHERE d.id = ?2")
    void confirmPickUp(LocalDate localDate, Long id);
    @Modifying
    @Transactional
    @Query("UPDATE Donation d SET d.pickUpStatus = 'nieodebrany', d.pickUpConfirmed = null WHERE d.id = ?1")
    void cancelConfirmPickUp(Long id);

}
