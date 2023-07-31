package pl.coderslab.charity.repository;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import pl.coderslab.charity.entity.Category;
import pl.coderslab.charity.entity.Donation;
import pl.coderslab.charity.entity.Institution;
import pl.coderslab.charity.entity.User;
import pl.coderslab.charity.service.CategoryService;
import pl.coderslab.charity.service.InstitutionService;
import pl.coderslab.charity.service.UserService;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
class DonationRepositoryTest {

    @Autowired
    private DonationRepository donationRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private InstitutionRepository institutionRepository;

    @BeforeEach
    void setUp(){
        Category category = Category
                .builder()
                .name("Category")
                .build();

        categoryRepository.save(category);

        Institution institution = Institution
                .builder()
                .name("Name")
                .description("Description")
                .build();

        institutionRepository.save(institution);


        Donation donation = Donation
                .builder()
                .quantity(5)
                .homeNumber("20")
                .flatNumber("2")
                .street("Cicha")
                .city("Warszawa")
                .zipCode("80-500")
                .phoneNumber("578446986")
                .pickUpDate(LocalDate.now())
                .pickUpTime(LocalTime.now())
                .pickUpStatus("nieodebrany")
                .pickUpConfirmed(LocalDate.now())
                .pickUpComment("Comment")
                .created(LocalDateTime.now())
                .institution(institution)
                .categories(Arrays.asList(category))
                .user(null)
                .build();

        Donation donation1 = Donation
                .builder()
                .quantity(10)
                .homeNumber("21")
                .flatNumber("26")
                .street("Wysoka")
                .city("Kraków")
                .zipCode("80-556")
                .phoneNumber("578446986")
                .pickUpDate(LocalDate.now())
                .pickUpTime(LocalTime.now())
                .pickUpStatus("nieodebrany")
                .pickUpConfirmed(LocalDate.now())
                .pickUpComment("Comment")
                .created(LocalDateTime.now())
                .institution(institution)
                .categories(Arrays.asList(category))
                .user(null)
                .build();

        donationRepository.save(donation);
        donationRepository.save(donation1);
    }

    @Test
    void DonationRepository_getSumOfQuantity_ReturnSum() {
        Optional<Long> sumOfQuantity = donationRepository.getSumOfQuantity();

        Assertions.assertThat(sumOfQuantity).isPresent();
        Assertions.assertThat(sumOfQuantity.get()).isEqualTo(15L);
    }

    @Test
    void DonationRepository_getSumOfDonations_ReturnSum() {
        Optional<Long> sumOfDonations = donationRepository.getSumOfDonations();

        Assertions.assertThat(sumOfDonations).isPresent();
        Assertions.assertThat(sumOfDonations.get()).isEqualTo(2L);
    }
}