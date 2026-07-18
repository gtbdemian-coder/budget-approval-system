package com.github.gtbdemian.budgetapprovalsystem.controller;

import com.github.gtbdemian.budgetapprovalsystem.domain.Notification;
import com.github.gtbdemian.budgetapprovalsystem.service.NotificationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/notifications")
public class NotificationController {

    private final NotificationService notificationService;

    public NotificationController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @GetMapping
    public String findByUserId(Model model) {
        List<Notification> notifications = notificationService.findByUserId(1L);
        model.addAttribute("notifications", notifications);
        return "notification/list";
    }

    @PostMapping("/{id}/read")
    public String updateIsRead(@PathVariable Long id) {
        notificationService.updateIsRead(id);
        return "redirect:/notifications";
    }
}
