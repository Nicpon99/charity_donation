package pl.coderslab.charity.service;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.charity.repository.InstitutionRepository;
import pl.coderslab.charity.entity.Institution;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class InstitutionService {

    private final InstitutionRepository institutionRepository;

    public List<Institution> findAll(){
        return institutionRepository.findAll();
    }

}
