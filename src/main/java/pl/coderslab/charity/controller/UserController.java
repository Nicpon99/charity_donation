package pl.coderslab.charity.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.aspectj.apache.bcel.generic.RET;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pl.coderslab.charity.entity.Role;
import pl.coderslab.charity.entity.User;
import pl.coderslab.charity.service.EmailSenderService;
import pl.coderslab.charity.service.RoleService;
import pl.coderslab.charity.service.UserService;

import java.security.Principal;
import java.util.NoSuchElementException;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    private final EmailSenderService senderService;

    private final RoleService roleService;


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


    @GetMapping("/admin/admins")
    public String getAllAdmins(Model model, Principal principal){
        User user = userService.findByUsername(principal.getName());

        model.addAttribute("principalAdminId", user.getId());

        Role role = roleService.findByName("ROLE_ADMIN");
        model.addAttribute("admins", userService.findByRole(role));

        return "admin-admins";
    }

    @GetMapping("/admin/admins/add")
    public String addAdmin(Model model){
        model.addAttribute("user", new User());
        return "admin-add-admin";
    }

    @PostMapping("/admin/admins/add")
    public String saveAdmin(@Valid User user, BindingResult result){
        if (result.hasErrors()){
            return "admin-add-admin";
        }

        userService.saveAdmin(user);

        return "redirect:/admin/admins";
    }

    @GetMapping("/admin/admins/edit/{adminId}")
    public String editAdmin(@PathVariable("adminId") Long adminId ,Model model, Principal principal){
        User user = userService.findById(adminId);
        model.addAttribute("user", user);
        return "admin-edit-admin";
    }

    @PostMapping("/admin/admins/update")
    public String updateAdmin(@Valid User user, BindingResult result){
        if (result.hasErrors()){
            return "admin-edit-admin";
        }

        userService.updateUser(user);

        return "redirect:/admin/admins";
    }

    @GetMapping("/admin/admins/delete/{adminId}")
    public String deleteAdmin(@PathVariable("adminId") Long adminId, Model model, Principal principal){
        model.addAttribute("adminId", adminId);

        return "admin-delete-admin";
    }

    @GetMapping("/admin/admins/delete/confirmed/{adminId}")
    public String confirmedDeleteAdmin(@PathVariable("adminId") Long adminId){
        User user = userService.findById(adminId);
        userService.deleteUserByIdWithRelations(user);
        return "redirect:/admin/admins";
    }


    @GetMapping("/admin/users")
    public String getUsers(Model model){
        Role role = roleService.findByName("ROLE_USER");
        model.addAttribute("users", userService.findByRole(role));
        return "admin-users";
    }

    @GetMapping("/admin/users/edit/{userId}")
    public String editUser(@PathVariable("userId") Long userId, Model model){
        User user = userService.findById(userId);
        model.addAttribute("user", user);
        return "admin-edit-user";
    }

    @PostMapping("/admin/users/update")
    public String updateUser(@Valid User user, BindingResult result){
        if (result.hasErrors()){
            return "admin-edit-user";
        }

        userService.updateUser(user);
        return "redirect:/admin/users";
    }


    @GetMapping("/admin/users/delete/{userId}")
    public String deleteUser(@PathVariable("userId") Long userId, Model model){
        model.addAttribute("userId", userId);
        return "admin-delete-user";
    }

    @GetMapping("/admin/users/delete/confirmed/{userId}")
    public String confirmedDeleteUser(@PathVariable("userId") Long userId){
        User user = userService.findById(userId);
        userService.deleteUserByIdWithRelations(user);
        return "redirect:/admin/users";
    }


    @GetMapping("/admin/users/block/{userId}")
    public String blockOrUnblockUser(@PathVariable("userId") Long userId){
        User user = userService.findById(userId);
        userService.blockOrUnblockUser(user);
        return "redirect:/admin/users";
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
