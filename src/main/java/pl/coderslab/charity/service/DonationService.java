package pl.coderslab.charity.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.charity.entity.Donation;
import pl.coderslab.charity.entity.User;
import pl.coderslab.charity.repository.DonationRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

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

    public List<Donation> findAll(){
        return donationRepository.findAll();
    }

    public List<Donation> findAllSorted(User user){
        return donationRepository.findAllByUserSorted(user);
    }

    public Donation findById(Long id){
        return donationRepository.findById(id).orElseThrow(
                () -> new NoSuchElementException("Not found donation with this ID"));
    }

    public void confirmPicUp(LocalDate localDate, Long id){
        donationRepository.confirmPickUp(localDate, id);
    }

    public void cancelConfirmPickUp(Long id){
        donationRepository.cancelConfirmPickUp(id);
    }

}
