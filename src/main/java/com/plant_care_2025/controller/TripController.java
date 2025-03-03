package com.plant_care_2025.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.plant_care_2025.model.Trip;
import com.plant_care_2025.service.TripService;

@Controller
@RequestMapping("/trips")
public class TripController {
	
	@Autowired
    private TripService tripService;


    // List all departments
    @GetMapping
    public String listTrips(Model model) {
        model.addAttribute("trips", tripService.getAllTrips());
        model.addAttribute("trip", new Trip()); // For form handling
        return "trips";
    }

    // Add or update a department
    @PostMapping("/save")
    public String saveTrip(@ModelAttribute Trip trip) {
        tripService.saveTrip(trip);
        return "redirect:/trips";
    }

    // Edit department
    @GetMapping("/edit/{id}")
    public String editTrip(@PathVariable Long id, Model model) {
        model.addAttribute("trip", tripService.getTripById(id));
        model.addAttribute("trips", tripService.getAllTrips());
        return "trips";
    }

    // Delete department
    @GetMapping("/delete/{id}")
    public String deleteTrip(@PathVariable Long id) {
        tripService.deleteTrip(id);
        return "redirect:/trips";
    }

}
