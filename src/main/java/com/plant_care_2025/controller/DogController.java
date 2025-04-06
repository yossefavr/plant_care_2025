package com.plant_care_2025.controller;

import com.plant_care_2025.model.Dog;
import com.plant_care_2025.repository.DogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class DogController {

    @Autowired
    private DogRepository dogRepository;

    // READ - Show all dogs and the form
    @GetMapping("/maor")
    public String showDogs(Model model) {
        List<Dog> dogs = dogRepository.findAll();
        model.addAttribute("dogs", dogs);
        model.addAttribute("newDog", new Dog()); // for form
        return "maor";
    }

    // CREATE or UPDATE - Save dog
    @PostMapping("/maor/save")
    public String saveDog(@ModelAttribute("newDog") Dog dog) {
        dogRepository.save(dog); // will update if ID exists
        return "redirect:/maor";
    }

    // UPDATE - Load existing dog into form
    @PostMapping("/maor/deleteById")
    public String deleteById(@RequestParam("id") Long id) {
        dogRepository.deleteById(id);
        return "redirect:/maor";
    }

    @PostMapping("/maor/edit")
    public String updateDog(@ModelAttribute Dog dog) {
        if (dogRepository.existsById(dog.getId())) {
            Dog dog2 = dogRepository.findById(dog.getId()).orElseThrow();
            dog2.setName(dog.getName());
            dog2.setBreed(dog.getBreed());
            dog2.setOwner(dog.getOwner());
            dogRepository.save(dog2); // update
        }
        return "redirect:/maor";
    }


    // DELETE
    @GetMapping("/maor/delete/{id}")
    public String deleteDog(@PathVariable Long id) {
        dogRepository.deleteById(id);
        return "redirect:/maor";
    }
}
