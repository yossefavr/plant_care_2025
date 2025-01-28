package com.plant_care_2025.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.plant_care_2025.model.Authority;
import com.plant_care_2025.repository.AuthorityRepository;

@Service
public class AuthorityService {

    @Autowired
    private AuthorityRepository authorityRepository;

    public List<Authority> getAllRoles() {
        return authorityRepository.findAll();
    }
}
