package pl.coderslab.charity.controller;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.context.WebApplicationContext;
import pl.coderslab.charity.entity.Donation;
import pl.coderslab.charity.entity.User;
import pl.coderslab.charity.service.CategoryService;
import pl.coderslab.charity.service.DonationService;
import pl.coderslab.charity.service.InstitutionService;
import pl.coderslab.charity.entity.Category;
import pl.coderslab.charity.entity.Institution;
import pl.coderslab.charity.service.UserService;
import pl.coderslab.charity.validation.FirstStep;
import pl.coderslab.charity.validation.FourthStep;
import pl.coderslab.charity.validation.SecondStep;
import pl.coderslab.charity.validation.ThirdStep;

import java.security.Principal;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequiredArgsConstructor
@SessionAttributes({"selectedCategories", "selectedQuantity", "selectedInstitution",
        "donationWithAddressAndPickUpData"})
public class DonationController {

    private final InstitutionService institutionService;
    private final CategoryService categoryService;

    private final DonationService donationService;

    private final UserService userService;

    @GetMapping("/donation/form/1")
    public String getDonationForm1(Model model){
        model.addAttribute("donation", new Donation());
        return "form-step-1";
    }



    @PostMapping("/donation/form/1")
    public String saveDonationForm1(@Validated(FirstStep.class) Donation donation, BindingResult result, Model model){
        if (result.hasErrors()){
            return "form-step-1";
        }

        model.addAttribute("selectedCategories", donation.getCategories());

        return "redirect:/donation/form/2#form2";
    }

    @GetMapping("/donation/form/2")
    public String getDonationForm2(Model model){
        model.addAttribute("donation", new Donation());
        return "form-step-2";
    }

    @PostMapping("/donation/form/2")
    public String saveDonationForm2(@Validated(SecondStep.class) Donation donation, BindingResult result, Model model){
        if (result.hasErrors()){
            return "form-step-2";
        }

        model.addAttribute("selectedQuantity", donation.getQuantity());

        return "redirect:/donation/form/3#form3";
    }

    @GetMapping("/donation/form/3")
    public String getDonationForm3(Model model){
        model.addAttribute("donation", new Donation());
        return "form-step-3";
    }

    @PostMapping("/donation/form/3")
    public String saveDonationForm3(@Validated(ThirdStep.class) Donation donation, BindingResult result, Model model){
        if (result.hasErrors()){
            return "form-step-3";
        }

        model.addAttribute("selectedInstitution", donation.getInstitution());

        return "redirect:/donation/form/4#form4";
    }

    @GetMapping("/donation/form/4")
    public String getDonationForm4(Model model){
        model.addAttribute("donation", new Donation());
        return "form-step-4";
    }

    @PostMapping("/donation/form/4")
    public String saveDonationForm4(@Validated(FourthStep.class) Donation donation, BindingResult result, Model model){
        if (result.hasErrors()){
            return "form-step-4";
        }

        model.addAttribute("donationWithAddressAndPickUpData", donation);

        return "redirect:/donation/form/summary#summary";
    }

    @GetMapping("/donation/form/summary")
    public String getDonationFormSummary(Model model, HttpSession session){
        return "form-summary";
    }

    @GetMapping("/donation/save")
    public String donationSave(HttpSession session, Principal principal){
        Donation donation = (Donation) session.getAttribute("donationWithAddressAndPickUpData");
        List<Category> categories = (List<Category>) session.getAttribute("selectedCategories");
        Integer quantity = (Integer) session.getAttribute("selectedQuantity");
        Institution institution = (Institution) session.getAttribute("selectedInstitution");

        donation.setCategories(categories);
        donation.setQuantity(quantity);
        donation.setInstitution(institution);


        User user = userService.findByUsername(principal.getName()).orElseThrow(
                () -> new UsernameNotFoundException(principal.getName()));

        donation.setUser(user);

        donationService.save(donation);


        return "form-confirmation";
    }


    @ModelAttribute("categories")
    public List<Category> getAllCategories(){
        return categoryService.findAll();
    }


    @ModelAttribute("institutions")
    public List<Institution> getAllInstitutions(){
        return institutionService.findAll();
    }

}
