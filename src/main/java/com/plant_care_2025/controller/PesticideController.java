package com.plant_care_2025.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.plant_care_2025.model.Pesticide;
import com.plant_care_2025.service.PesticideService;

@Controller
public class PesticideController {

    @Autowired
    private PesticideService pesticideService;

    @GetMapping("/pesticides")
    public String listPesticides(Model model) {
        List<Pesticide> pesticides = pesticideService.fetchPesticides();
        model.addAttribute("pesticides", pesticides);
        return "pesticides";
    }
}

