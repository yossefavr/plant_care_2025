package com.plant_care_2025.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.plant_care_2025.model.Department;
import com.plant_care_2025.service.DepartmentService;

@Controller
@RequestMapping("/departments")
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

    // List all departments
    @GetMapping
    public String listDepartments(Model model) {
        model.addAttribute("departments", departmentService.getAllDepartments());
        model.addAttribute("department", new Department()); // For form handling
        return "departments";
    }

    // Add or update a department
    @PostMapping("/save")
    public String saveDepartment(@ModelAttribute Department department) {
        departmentService.saveDepartment(department);
        return "redirect:/departments";
    }

    // Edit department
    @GetMapping("/edit/{id}")
    public String editDepartment(@PathVariable Long id, Model model) {
        model.addAttribute("department", departmentService.getDepartmentById(id));
        model.addAttribute("departments", departmentService.getAllDepartments());
        return "departments";
    }

    // Delete department
    @GetMapping("/delete/{id}")
    public String deleteDepartment(@PathVariable Long id) {
        departmentService.deleteDepartment(id);
        return "redirect:/departments";
    }
}
