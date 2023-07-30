package pl.coderslab.charity.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.charity.entity.Donation;
import pl.coderslab.charity.entity.User;
import pl.coderslab.charity.repository.DonationRepository;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class DonationService {

    private final DonationRepository donationRepository;

    public Long getSumOfQuantity(){
        return donationRepository.getSumOfQuantity().orElse(0L);
    }

    public Long getSumOfDonations(){
        return donationRepository.getSumOfDonations().orElse(0L);
    }

    public void save(Donation donation){
        donationRepository.save(donation);
    }

    public List<Donation> findByUser(User user){
        return donationRepository.findByUser(user);
    }

}
