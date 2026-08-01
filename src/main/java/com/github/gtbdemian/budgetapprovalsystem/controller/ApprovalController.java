package com.github.gtbdemian.budgetapprovalsystem.controller;

import com.github.gtbdemian.budgetapprovalsystem.domain.Approval;
import com.github.gtbdemian.budgetapprovalsystem.service.ApprovalService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/approvals")
public class ApprovalController {

    private final ApprovalService approvalService;

    public ApprovalController(ApprovalService approvalService) {
        this.approvalService = approvalService;
    }

    @PostMapping
    public String insert(Approval approval) {
        approvalService.insert(approval);
        return "redirect:/budget-requests/" + approval.getBudgetRequestId();
    }
}
