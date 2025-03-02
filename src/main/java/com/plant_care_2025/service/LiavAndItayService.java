package com.plant_care_2025.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.plant_care_2025.model.LiavAndItay;
import com.plant_care_2025.repository.LiavAndItayRepository;

@Service
public class LiavAndItayService {
	@Autowired
    private LiavAndItayRepository listOfEventRepository;
	
    // Retrieve all events
    public List<LiavAndItay> getAllEvents() {
        return listOfEventRepository.findAll();
    }
    // Retrieve event by it's id
    public LiavAndItay getEventById(Long id) {
		return listOfEventRepository.findById(id).orElse(null);
	}
    
    // Save or update an event
    public void saveEvent(LiavAndItay event) {
        listOfEventRepository.save(event);
    }

    // Delete an event by ID
    public void deleteEvent(Long id) {
        listOfEventRepository.deleteById(id);
    }
}
