package pl.coderslab.charity.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pl.coderslab.charity.entity.Institution;
import pl.coderslab.charity.service.InstitutionService;

import java.util.NoSuchElementException;

@Controller
@RequiredArgsConstructor
public class InstitutionController {

    private final InstitutionService institutionService;

    @GetMapping("/admin/institutions")
    public String getAllInstitutions(Model model){
        model.addAttribute("institutions", institutionService.findAll());
        return "admin-institutions";
    }

    @GetMapping("/admin/institutions/add")
    public String addInstitution(Model model){
        model.addAttribute("institution", new Institution());
        return "admin-add-institution";
    }

    @PostMapping("/admin/institutions/add")
    public String saveInstitution(@Valid Institution institution, BindingResult result){
        if (result.hasErrors()){
            return "admin-add-institution";
        }

        institutionService.saveInstitution(institution);

        return "redirect:/admin/institutions";
    }

    @GetMapping("/admin/institutions/edit/{institutionId}")
    public String editInstitution(@PathVariable("institutionId") Long institutionId, Model model)
            throws NoSuchElementException {
        Institution institution = institutionService.findById(institutionId).orElseThrow(
                () -> new NoSuchElementException("Not found institution with this id: " + institutionId));

        model.addAttribute("institution", institution);

        return "admin-edit-institution";
    }

    @PostMapping("/admin/institutions/update")
    public String updateInstitution(@Valid Institution institution, BindingResult result){
        if (result.hasErrors()){
            return "admin-edit-institution";
        }

        institutionService.updateInstitution(institution);

        return "redirect:/admin/institutions";
    }

    @GetMapping("/admin/institutions/delete/{institutionId}")
    public String deleteInstitution(@PathVariable("institutionId") Long institutionId){
        return "admin-delete-institution";
    }

    @GetMapping("/admin/institutions/delete/confirmed/{institutionId}")
    public String confirmedDeleteInstitution(@PathVariable("institutionId") Long institutionId){
        institutionService.deleteInstitutionById(institutionId);
        return "redirect:/admin/institutions";
    }

}
