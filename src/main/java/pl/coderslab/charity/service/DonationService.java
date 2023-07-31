package pl.coderslab.charity.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.charity.entity.Category;
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

    public String getMessageWithDonationDetails(Donation donation){
        StringBuilder message = new StringBuilder();

        message.append("Quantity: ").append(donation.getQuantity()).append("\n");
        message.append("Home Number: ").append(donation.getHomeNumber()).append("\n");
        message.append("Flat Number: ").append(donation.getFlatNumber()).append("\n");
        message.append("Street: ").append(donation.getStreet()).append("\n");
        message.append("City: ").append(donation.getCity()).append("\n");
        message.append("Zip Code: ").append(donation.getZipCode()).append("\n");
        message.append("Phone Number: ").append(donation.getPhoneNumber()).append("\n");
        message.append("Pick-up Date: ").append(donation.getPickUpDate()).append("\n");
        message.append("Pick-up Time: ").append(donation.getPickUpTime()).append("\n");
        message.append("Pick-up Status: ").append(donation.getPickUpStatus()).append("\n");
        message.append("Pick-up Confirmed: ").append(donation.getPickUpConfirmed()).append("\n");
        message.append("Created: ").append(donation.getCreated()).append("\n");
        message.append("Pick-up Comment: ").append(donation.getPickUpComment()).append("\n");
        message.append("Institution: ").append(donation.getInstitution().getName()).append("\n");

        message.append("Categories:").append("\n");
        for (Category category : donation.getCategories()) {
            message.append("- ").append(category.getName()).append("\n");
        }

        message.append("User: ").append(donation.getUser().getUsername()).append("\n");

        return message.toString();
    }

}
