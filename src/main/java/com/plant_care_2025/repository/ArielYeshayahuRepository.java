package com.plant_care_2025.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.plant_care_2025.model.ArielYeshayahu;

@Repository
public interface ArielYeshayahuRepository extends JpaRepository<ArielYeshayahu, Long> {
    Optional<ArielYeshayahu> findByUsername(String username);
}