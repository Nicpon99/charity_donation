package pl.coderslab.charity.service;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.charity.repository.InstitutionRepository;
import pl.coderslab.charity.entity.Institution;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class InstitutionService {

    private final InstitutionRepository institutionRepository;

    public List<Institution> findAll(){
        return institutionRepository.findAll();
    }

    public void saveInstitution(Institution institution){
        institutionRepository.save(institution);
    }

    public Optional<Institution> findById(Long id){
        return institutionRepository.findById(id);
    }

    public void updateInstitution(Institution institution){
        institutionRepository.updateInstitution(institution.getName(), institution.getDescription(),
                institution.getId());
    }

    public void deleteInstitutionById(Long id) {
        institutionRepository.deleteById(id);
    }

}
