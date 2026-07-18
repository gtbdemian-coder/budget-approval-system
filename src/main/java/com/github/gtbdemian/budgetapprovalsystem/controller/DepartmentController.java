package com.github.gtbdemian.budgetapprovalsystem.controller;

import com.github.gtbdemian.budgetapprovalsystem.domain.Department;
import com.github.gtbdemian.budgetapprovalsystem.service.DepartmentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/departments")
public class DepartmentController {

    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping
    public String findAll(Model model) {
        List<Department> departments = departmentService.findAll();
        model.addAttribute("departments", departments);
        return "department/list";
    }

    @GetMapping("/{id}")
    public String findById(@PathVariable Long id, Model model) {
        Department department = departmentService.findById(id);
        model.addAttribute("department", department);
        return "department/detail";
    }
}
