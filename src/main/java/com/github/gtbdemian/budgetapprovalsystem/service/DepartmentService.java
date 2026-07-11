package com.github.gtbdemian.budgetapprovalsystem.service;

import com.github.gtbdemian.budgetapprovalsystem.domain.Department;
import com.github.gtbdemian.budgetapprovalsystem.mapper.DepartmentMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {

    private final DepartmentMapper departmentMapper;

    public DepartmentService(DepartmentMapper departmentMapper) {
        this.departmentMapper = departmentMapper;
    }

    public List<Department> findAll() {
        return departmentMapper.findAll();
    }

    public Department findById(Long id) {
        return departmentMapper.findById(id);
    }
}
