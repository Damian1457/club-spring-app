package pl.damian.wasik.spring.app.club.web;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.damian.wasik.spring.app.club.repository.entity.UserEntity;
import pl.damian.wasik.spring.app.club.service.UserService;
import pl.damian.wasik.spring.app.club.web.model.Registration;

@Controller
@RequestMapping(value = "/register")
public class AuthController {
    private UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String createView(Model model) {
        Registration user = new Registration();
        model.addAttribute("user", user);
        return "register";
    }

    @PostMapping("/save")
    public String register(@Valid @ModelAttribute("user") Registration user,
                           BindingResult bindingResult, Model model) {
        UserEntity existingUserEmail = userService.findByEmail(user.getEmail());
        if (existingUserEmail != null && existingUserEmail.getEmail() != null && !existingUserEmail.getEmail().isEmpty()) {
            bindingResult.rejectValue("email", "There is already a user with this email/username.");
        }

        UserEntity existingUserUsername = userService.findBtUsername(user.getUsername());
        if (existingUserUsername != null && existingUserUsername.getUsername() != null && !existingUserUsername.getUsername().isEmpty()) {
            bindingResult.rejectValue("username", "There is already a user with this email/username.");
        }

        if (bindingResult.hasErrors()) {
            model.addAttribute("user", user);
            return "register";
        }
        userService.createUser(user);
        return "redirect:/clubs?success";
    }
}
