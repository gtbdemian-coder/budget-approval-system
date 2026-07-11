package com.github.gtbdemian.budgetapprovalsystem.service;

import com.github.gtbdemian.budgetapprovalsystem.domain.Approval;
import com.github.gtbdemian.budgetapprovalsystem.mapper.ApprovalMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApprovalService {

    private final ApprovalMapper approvalMapper;

    public ApprovalService(ApprovalMapper approvalMapper) {
        this.approvalMapper = approvalMapper;
    }

    public List<Approval> findByBudgetRequestId(Long budgetRequestId) {
        return approvalMapper.findByBudgetRequestId(budgetRequestId);
    }

    public Approval findById(Long id) {
        return approvalMapper.findById(id);
    }

    public void insert(Approval approval) {
        approvalMapper.insert(approval);
    }
}
