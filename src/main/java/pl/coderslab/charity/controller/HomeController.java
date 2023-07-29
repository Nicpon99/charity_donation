package pl.coderslab.charity.controller;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.entity.User;
import pl.coderslab.charity.service.DonationService;
import pl.coderslab.charity.service.InstitutionService;
import pl.coderslab.charity.entity.Institution;
import pl.coderslab.charity.service.UserService;

import java.util.List;


@Controller
@RequiredArgsConstructor
public class HomeController {

    private final InstitutionService institutionService;
    private final DonationService donationService;

    private final UserService userService;

    @RequestMapping("/")
    public String homeAction(Model model){

//        if (userService.findAll().isEmpty()){
//            User admin = User
//                    .builder()
//                    .username("")
//                    .name("")
//                    .surname("")
//                    .password("")
//                    .build();
//
//            userService.saveAdmin(admin);
//
//        }

        return "homepage";
    }


    @ModelAttribute("institutions")
    public List<Institution> getAvailableInstitutions(){
        return institutionService.findAll();
    }

    @ModelAttribute("bags")
    public Long getAllBags(){
        return donationService.getSumOfQuantity();
    }

    @ModelAttribute("donations")
    public Long getSumOfDonations(){
        return donationService.getSumOfDonations();
    }

}

