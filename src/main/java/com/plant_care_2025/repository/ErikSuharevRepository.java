package com.plant_care_2025.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.plant_care_2025.model.ErikSuharev;

@Repository
public interface ErikSuharevRepository extends JpaRepository<ErikSuharev, Long> {
    Optional<ErikSuharev> findByUsername(String username);
}