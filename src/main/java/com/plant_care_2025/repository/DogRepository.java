package com.plant_care_2025.repository;

import com.plant_care_2025.model.Dog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DogRepository extends JpaRepository<Dog, Long> {
    // You can add custom queries later if needed
}
