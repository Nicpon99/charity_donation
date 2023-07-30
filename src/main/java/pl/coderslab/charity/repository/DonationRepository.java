package pl.coderslab.charity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.coderslab.charity.entity.Donation;
import pl.coderslab.charity.entity.User;

import java.util.List;
import java.util.Optional;

@Repository
public interface DonationRepository extends JpaRepository<Donation, Long> {

    @Query(value = "SELECT SUM(quantity) FROM donations", nativeQuery = true)
    Optional<Long> getSumOfQuantity();

    @Query(value = "SELECT COUNT(*) FROM donations", nativeQuery = true)
    Optional<Long> getSumOfDonations();

    List<Donation> findByUser(User user);

}
