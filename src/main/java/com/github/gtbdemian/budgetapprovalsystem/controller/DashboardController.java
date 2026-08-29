package com.github.gtbdemian.budgetapprovalsystem.controller;

import com.github.gtbdemian.budgetapprovalsystem.domain.BudgetRequestStatus;
import com.github.gtbdemian.budgetapprovalsystem.domain.User;
import com.github.gtbdemian.budgetapprovalsystem.service.BudgetRequestService;
import com.github.gtbdemian.budgetapprovalsystem.service.NotificationService;
import com.github.gtbdemian.budgetapprovalsystem.service.UserService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardController {

    private final BudgetRequestService budgetRequestService;
    private final NotificationService notificationService;
    private final UserService userService;

    public DashboardController(BudgetRequestService budgetRequestService, NotificationService notificationService, UserService userService) {
        this.budgetRequestService = budgetRequestService;
        this.notificationService = notificationService;
        this.userService = userService;
    }

    @GetMapping("/dashboard")
    public String dashboard(@AuthenticationPrincipal UserDetails userDetails, Model model) {

        User user = userService.findByEmployeeNumber(userDetails.getUsername());

        int pendingCount = budgetRequestService.countByUserIdAndStatus(user.getId(), BudgetRequestStatus.PENDING.name());
        int approvedCount = budgetRequestService.countByUserIdAndStatus(user.getId(), BudgetRequestStatus.APPROVED.name());
        int rejectedCount = budgetRequestService.countByUserIdAndStatus(user.getId(), BudgetRequestStatus.REJECTED.name());

        model.addAttribute("pendingCount", pendingCount);
        model.addAttribute("approvedCount", approvedCount);
        model.addAttribute("rejectedCount", rejectedCount);
        model.addAttribute("notifications", notificationService.findByUserId(user.getId()));

        return "dashboard";
    }
}
