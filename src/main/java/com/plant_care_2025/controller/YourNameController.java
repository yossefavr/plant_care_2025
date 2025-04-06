package com.plant_care_2025.controller;

import com.plant_care_2025.model.User;
import com.plant_care_2025.model.Authority;
import com.plant_care_2025.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Controller
public class YourNameController {

    @GetMapping("/yourname")
    public String showUsers(Model model) {
        List<User> users = List.of(
                createUser(1L, "jdoe", "John", "Doe", "john@example.com", "Admin"),
                createUser(2L, "asmith", "Alice", "Smith", "alice@example.com", "User"),
                createUser(3L, "bwayne", "Bruce", "Wayne", "batman@example.com", "Superuser")
        );

        model.addAttribute("users", users);
        return "yourname";
    }

    private User createUser(Long id, String username, String firstName, String lastName, String email, String roleName) {
        Authority role = new Authority();
        role.setName(roleName);

        User user = new User();
        user.setId(id);
        user.setUserName(username);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setEmail(email);
        user.setRole(role);
        return user;
    }
    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public String showUser(Model model) {
        model.addAttribute("users", userRepository.findAll());
        return "user-list";
    }
    @GetMapping("/new")
    public String saveNewUser(@ModelAttribute("user") User user) {
        userRepository.save(user);
        return "redirect:/yourname";
    }
    @GetMapping("/edit/{id}")
    public String editUser(@PathVariable Long id, Model model) {
        Optional<User> user = userRepository.findById(id);
        user.ifPresent(value -> model.addAttribute("user", value));
        return "user-form";
    }
    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable Long id, Model model) {
        Optional<User> user = userRepository.findById(id);
        user.ifPresent(value -> userRepository.delete(value));
        return "redirect:/yourname";
    }
}
