package app.controllers;

import app.models.Officer;
import app.repositories.AppuserRepo;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class OfficerController {


    private final AppuserRepo appuserRepo;

    public OfficerController(AppuserRepo appuserRepo) {
        this.appuserRepo = appuserRepo;
    }

    @GetMapping("/register")
    public String registerform(Model model) {
        model.addAttribute("user", new Officer());
        return "register";
    }
    @PostMapping("/register")
    public String processRestration(Officer user) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encodedPassword = encoder.encode(user.getPassword());
        user.setPassword(encodedPassword);

        appuserRepo.save(user);
        return "redirect:/login";
    }

}