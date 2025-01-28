package com.plant_care_2025.controller;


import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ListController {

    @GetMapping("/list")
    public String showList(Model model) {
        // Create a sample list of items
        List<String> items = Arrays.asList("Item 1", "Item 2", "Item 3", "Item 4");

        // Add the list to the model
        model.addAttribute("items", items);
        return "list"; // Points to list.html
    }
}