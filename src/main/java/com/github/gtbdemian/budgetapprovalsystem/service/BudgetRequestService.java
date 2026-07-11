package com.github.gtbdemian.budgetapprovalsystem.service;

import com.github.gtbdemian.budgetapprovalsystem.domain.BudgetRequest;
import com.github.gtbdemian.budgetapprovalsystem.mapper.BudgetRequestMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BudgetRequestService {

    private final BudgetRequestMapper budgetRequestMapper;

    public BudgetRequestService(BudgetRequestMapper budgetRequestMapper) {
        this.budgetRequestMapper = budgetRequestMapper;
    }

    public List<BudgetRequest> findAll() {
        return budgetRequestMapper.findAll();
    }

    public BudgetRequest findById(Long id) {
        return budgetRequestMapper.findById(id);
    }

    public void insert(BudgetRequest budgetRequest) {
        budgetRequestMapper.insert(budgetRequest);
    }

    public void update(BudgetRequest budgetRequest) {
        budgetRequestMapper.update(budgetRequest);
    }

    public void delete(Long id) {
        budgetRequestMapper.delete(id);
    }
}
