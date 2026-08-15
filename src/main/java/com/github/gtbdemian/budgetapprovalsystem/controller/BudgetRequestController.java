package com.github.gtbdemian.budgetapprovalsystem.controller;

import com.github.gtbdemian.budgetapprovalsystem.domain.BudgetRequest;
import com.github.gtbdemian.budgetapprovalsystem.domain.BudgetRequestStatus;
import com.github.gtbdemian.budgetapprovalsystem.domain.User;
import com.github.gtbdemian.budgetapprovalsystem.dto.ApprovalDto;
import com.github.gtbdemian.budgetapprovalsystem.service.ApprovalService;
import com.github.gtbdemian.budgetapprovalsystem.service.BudgetRequestService;
import com.github.gtbdemian.budgetapprovalsystem.service.UserService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
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
    private final UserService userService;

    public BudgetRequestController(BudgetRequestService budgetRequestService, ApprovalService approvalService, UserService userService) {
        this.budgetRequestService = budgetRequestService;
        this.approvalService = approvalService;
        this.userService = userService;
    }

    /** 예산신청서 전체 목록 조회 */
    @GetMapping
    public String findAll(Model model) {
        List<BudgetRequest> budgetRequests = budgetRequestService.findAll();
        model.addAttribute("budgetRequests", budgetRequests);
        return "budget-request/list";
    }

    /** 예산신청서 단건 조회 */
    @GetMapping("/{id}")
    public String findById(@PathVariable Long id, Model model) {
        BudgetRequest budgetRequest = budgetRequestService.findById(id);
        List<ApprovalDto> approvals = approvalService.findByBudgetRequestId(id);
        model.addAttribute("budgetRequest", budgetRequest);
        model.addAttribute("approvals", approvals);
        return "budget-request/detail";
    }

    /** 예산신청서 신규 등록 */
    @PostMapping
    public String insert(BudgetRequest budgetRequest, @AuthenticationPrincipal UserDetails userDetails) {
        User user = userService.findByEmployeeNumber(userDetails.getUsername());
        budgetRequest.setUserId(user.getId());
        budgetRequest.setStatus(BudgetRequestStatus.PENDING.name());
        budgetRequestService.insert(budgetRequest);
        return "redirect:/budget-requests";
    }

    /** 예산신청서 수정 */
    @PostMapping("/{id}/update")
    public String update(@PathVariable Long id, BudgetRequest budgetRequest) {
        budgetRequest.setId(id);
        budgetRequestService.update(budgetRequest);
        return "redirect:/budget-requests";
    }

    /** 예산신청서 삭제 */
    @PostMapping("/{id}/delete")
    public String delete(@PathVariable Long id) {
        budgetRequestService.delete(id);
        return "redirect:/budget-requests";
    }

    /** 예산신청서 작성 폼 페이지 이동 */
    @GetMapping("/new")
    public String form() {
        return "budget-request/form";
    }
}
