package com.plant_care_2025.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ArielYeshayahuController{

    @GetMapping("/user")
    public String getUserDetails(Model model) {
        // Example user data - replace with actual data retrieval logic
        User user = new User("Ariel Yeshayhu", "ariel@example.com", "2025-02-28");

        model.addAttribute("user", user);
        return "ArielYeshayhu"; // Thymeleaf template name
    }

    // User class for demonstration purposes
    static class User {
        private String username;
        private String email;
        private String lastVisit;

        public User(String username, String email, String lastVisit) {
            this.username = username;
            this.email = email;
            this.lastVisit = lastVisit;
        }

        public String getUsername() {
            return username;
        }

        public String getEmail() {
            return email;
        }

        public String getLastVisit() {
            return lastVisit;
        }
    }
}