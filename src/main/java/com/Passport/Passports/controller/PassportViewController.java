package com.Passport.Passports.controller;

import com.Passport.Passports.service.PassportApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PassportViewController {

    private final PassportApplicationService service;

    @Autowired
    public PassportViewController(PassportApplicationService service) {
        this.service = service;
    }

    @GetMapping("/")
    public String showApplications(Model model) {
        try {
            model.addAttribute("applications", service.findAll());
            return "passport_list"; // src/main/resources/templates/passport_list.html
        } catch (Exception e) {
            e.printStackTrace(); // Log the error for debugging (consider logging to a file in production)
            model.addAttribute("error", "Unable to fetch passport applications at the moment.");
            return "error_page"; // src/main/resources/templates/error_page.html (you should create this)
        }
    }
}
