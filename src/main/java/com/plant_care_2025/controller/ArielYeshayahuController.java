package com.plant_care_2025.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/plants")
public class ArielYeshayahuController{
    @Autowired
    private PlantService plantService;

    @GetMapping
    public String listPlants(Model model) {
        List<Plant> plants = plantService.getAllPlants();
        model.addAttribute("plants", plants);
        return "plants";
    }

    @PostMapping("/add")
    public String addPlant(@ModelAttribute Plant plant) {
        plantService.savePlant(plant);
        return "redirect:/plants";
    }

    @GetMapping("/delete/{id}")
    public String deletePlant(@PathVariable Long id) {
        plantService.deletePlant(id);
        return "redirect:/plants";
    }
}