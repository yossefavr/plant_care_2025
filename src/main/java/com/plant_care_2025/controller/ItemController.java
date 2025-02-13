package com.plant_care_2025.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.plant_care_2025.model.Item;
import com.plant_care_2025.service.ItemService;

public class ItemController {
	@Autowired
    private ItemService itemService;

    // List all items
    @GetMapping
    public String listItems(Model model) {
        model.addAttribute("items", itemService.getAllItems());
        model.addAttribute("item", new Item()); // For form handling
        return "items";
    }

    // Add or update a item
    @PostMapping("/save")
    public String saveItem(@ModelAttribute Item item) {
        itemService.saveItem(item);
        return "redirect:/items";
    }

    // Edit item
    @GetMapping("/edit/{id}")
    public String editItem(@PathVariable Long id, Model model) {
        model.addAttribute("item", itemService.getItemById(id));
        model.addAttribute("items", itemService.getAllItems());
        return "items";
    }

    // Delete item
    @GetMapping("/delete/{id}")
    public String deleteItem(@PathVariable Long id) {
        itemService.deleteItem(id);
        return "redirect:/items";
    }
}
