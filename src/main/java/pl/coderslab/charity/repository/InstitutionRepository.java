package pl.coderslab.charity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.charity.entity.Institution;

import java.util.Optional;

@Repository
public interface InstitutionRepository extends JpaRepository<Institution, Long> {

    @Modifying
    @Transactional
    @Query("UPDATE Institution i SET i.name = ?1, i.description = ?2 WHERE i.id = ?3")
    void updateInstitution(String name, String description, Long id);

}
