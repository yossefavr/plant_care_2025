package com.plant_care_2025.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.plant_care_2025.model.ArielYeshayahu;
import com.plant_care_2025.repository.ArielYeshayahuRepository;

//Service
@Service
public class ArielYeshayahuService {
 private final ArielYeshayahuRepository userRepository;

 @Autowired
 public ArielYeshayahuService(ArielYeshayahuRepository userRepository) {
     this.userRepository = userRepository;
 }

 public Optional<ArielYeshayahu> getUserByUsername(String username) {
     return userRepository.findByUsername(username);
 }
}