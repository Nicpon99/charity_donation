package pl.coderslab.charity.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import pl.coderslab.charity.entity.User;
import pl.coderslab.charity.service.EmailSenderService;
import pl.coderslab.charity.service.UserService;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    private final EmailSenderService senderService;

    @GetMapping("/register/user")
    public String registerUser(Model model){
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/register/user")
    public String saveUser(@Valid User user, BindingResult result){
        if (result.hasErrors()){
            return "register";
        }
        userService.saveUser(user);

        senderService.sendEmail(user.getUsername(), "Welcome", "Witamy w aplikacji");

        return "redirect:/register/confirmation";
    }

    @GetMapping("/register/confirmation")
    public String getRegisterConfirmation(){
        return "register-confirmation";
    }

    @GetMapping("/admin/homepage")
    public String getAdminHomepage(){
        return "admin-homepage";
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }


    @GetMapping("/logout")
    public String logout(){
        return "logout";
    }


}
