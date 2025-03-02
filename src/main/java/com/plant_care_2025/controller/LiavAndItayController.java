package com.plant_care_2025.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.plant_care_2025.model.LiavAndItay;
import com.plant_care_2025.service.LiavAndItayService;

@Controller
@RequestMapping("/events")
public class LiavAndItayController {
	@Autowired
    private LiavAndItayService listOfEventService;

    // Display all events
    @GetMapping
    public String listEvents(Model model) {
        model.addAttribute("events", listOfEventService.getAllEvents());
        model.addAttribute("event", new LiavAndItay()); // For form handling
        return "events";
    }

    // Save or update an event
    @PostMapping("/save")
    public String saveEvent(@ModelAttribute LiavAndItay event) {
        listOfEventService.saveEvent(event);
        return "redirect:/events";
    }

    // Edit an event
    @GetMapping("/edit/{id}")
    public String editEvent(@PathVariable Long id, Model model) {
    	model.addAttribute("event", listOfEventService.getEventById(id));
        model.addAttribute("events", listOfEventService.getAllEvents());
        return "events";
    }

    // Delete an event
    @GetMapping("/delete/{id}")
    public String deleteEvent(@PathVariable Long id) {
        listOfEventService.deleteEvent(id);
        return "redirect:/events";
    }
}

