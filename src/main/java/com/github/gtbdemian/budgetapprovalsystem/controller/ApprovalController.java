package com.github.gtbdemian.budgetapprovalsystem.controller;

import com.github.gtbdemian.budgetapprovalsystem.domain.Approval;
import com.github.gtbdemian.budgetapprovalsystem.service.ApprovalService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/approvals")
public class ApprovalController {

    private final ApprovalService approvalService;

    public ApprovalController(ApprovalService approvalService) {
        this.approvalService = approvalService;
    }

    @GetMapping("/{id}")
    public String findById(@PathVariable Long id, Model model) {
        Approval approval = approvalService.findById(id);
        model.addAttribute("approval", approval);
        return "approval/detail";
    }

    @PostMapping
    public String insert(Approval approval) {
        approvalService.insert(approval);
        return "redirect:/budget-requests/" + approval.getBudgetRequestId();
    }
}
