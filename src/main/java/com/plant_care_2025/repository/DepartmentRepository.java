package com.plant_care_2025.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.plant_care_2025.model.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
}
