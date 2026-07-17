package com.github.gtbdemian.budgetapprovalsystem.controller;

import com.github.gtbdemian.budgetapprovalsystem.domain.Approval;
import com.github.gtbdemian.budgetapprovalsystem.domain.BudgetRequest;
import com.github.gtbdemian.budgetapprovalsystem.service.ApprovalService;
import com.github.gtbdemian.budgetapprovalsystem.service.BudgetRequestService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/budget-requests")
public class BudgetRequestController {

    private final BudgetRequestService budgetRequestService;
    private final ApprovalService approvalService;

    public BudgetRequestController(BudgetRequestService budgetRequestService, ApprovalService approvalService) {
        this.budgetRequestService = budgetRequestService;
        this.approvalService = approvalService;
    }

    @GetMapping
    public String findAll(Model model) {
        List<BudgetRequest> budgetRequests = budgetRequestService.findAll();
        model.addAttribute("budgetRequests", budgetRequests);
        return "budget-request/list";
    }

    @GetMapping("/{id}")
    public String findById(@PathVariable Long id, Model model) {
        BudgetRequest budgetRequest = budgetRequestService.findById(id);
        List<Approval> approvals = approvalService.findByBudgetRequestId(id);
        model.addAttribute("budgetRequest", budgetRequest);
        model.addAttribute("approvals", approvals);
        return "budget-request/detail";
    }

    @PostMapping
    public String insert(BudgetRequest budgetRequest) {
        budgetRequestService.insert(budgetRequest);
        return "redirect:/budget-requests";
    }

    @PostMapping("/{id}/update")
    public String update(@PathVariable Long id, BudgetRequest budgetRequest) {
        budgetRequest.setId(id);
        budgetRequestService.update(budgetRequest);
        return "redirect:/budget-requests";
    }

    @PostMapping("/{id}/delete")
    public String delete(@PathVariable Long id) {
        budgetRequestService.delete(id);
        return "redirect:/budget-requests";
    }
}
