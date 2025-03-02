package com.plant_care_2025.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.plant_care_2025.model.ErikSuharev;
import com.plant_care_2025.repository.ErikSuharevRepository;

//Service
@Service
public class ErikSuharevService {
 private final ErikSuharevRepository userRepository;

 @Autowired
 public ErikSuharevService(ErikSuharevRepository userRepository) {
     this.userRepository = userRepository;
 }

 public Optional<ErikSuharev> getUserByUsername(String username) {
     return userRepository.findByUsername(username);
 }
}