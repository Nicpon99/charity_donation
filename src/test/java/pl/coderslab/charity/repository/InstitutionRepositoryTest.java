package pl.coderslab.charity.repository;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import pl.coderslab.charity.entity.Institution;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
class InstitutionRepositoryTest {

    @Autowired
    private InstitutionRepository institutionRepository;

    @Test
    public void InstitutionRepository_Save_ReturnSavedInstitution(){
        Institution institution = Institution
                .builder()
                .name("name of the institution")
                .description("description of the institution")
                .build();

        Institution savedInstitution = institutionRepository.save(institution);

        Assertions.assertThat(savedInstitution).isNotNull();
        Assertions.assertThat(savedInstitution.getId()).isGreaterThan(0);
    }

    @Test
    public void InstitutionRepository_findAll_ReturnMoreThenOneInstitution(){
        Institution institution1 = Institution
                .builder()
                .name("Name1")
                .description("Description1")
                .build();

        Institution institution2 = Institution
                .builder()
                .name("Name2")
                .description("Description2")
                .build();

        institutionRepository.save(institution1);
        institutionRepository.save(institution2);

        List<Institution> institutions = institutionRepository.findAll();

        Assertions.assertThat(institutions).hasSize(2);
        Assertions.assertThat(institutions).isNotNull();
    }


    @Test
    public void InstitutionRepository_findById_ReturnInstitution(){
        Institution institution1 = Institution
                .builder()
                .name("Name1")
                .description("Description1")
                .build();

        institutionRepository.save(institution1);

        Institution institution = institutionRepository.findById(institution1.getId()).get();

        Assertions.assertThat(institution1).isNotNull();
    }



}