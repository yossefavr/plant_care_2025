package com.plant_care_2025.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.plant_care_2025.model.Item;

public interface ItemRepository extends JpaRepository<Item, Long> {

}
