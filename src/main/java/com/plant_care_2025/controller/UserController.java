package com.plant_care_2025.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.plant_care_2025.model.User;
import com.plant_care_2025.service.AuthorityService;
import com.plant_care_2025.service.UserService;

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private AuthorityService authorityService;

    @GetMapping
    public String listUsers(Model model) {
        model.addAttribute("user", new User()); // Pass a blank User object
        model.addAttribute("users", userService.getAllUsers());
        model.addAttribute("roles", authorityService.getAllRoles());
        return "user-management";
    }



    @PostMapping("/save")
    public String saveUser(@ModelAttribute("user") User user) {
        userService.saveUser(user);
        return "redirect:/users";
    }

    @GetMapping("/edit/{id}")
    public String editUser(@PathVariable Long id, Model model) {
        User user = userService.getUserById(id);
        model.addAttribute("user", user); // Populate form with existing user data
        model.addAttribute("users", userService.getAllUsers());
        model.addAttribute("roles", authorityService.getAllRoles());
        return "user-management";
    }


    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return "redirect:/users";
    }
}
