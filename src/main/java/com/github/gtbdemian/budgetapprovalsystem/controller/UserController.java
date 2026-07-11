package com.github.gtbdemian.budgetapprovalsystem.controller;

import com.github.gtbdemian.budgetapprovalsystem.domain.User;
import com.github.gtbdemian.budgetapprovalsystem.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String findAll(Model model) {
        List<User> users = userService.findAll();
        model.addAttribute("users", users);
        return "user/list";
    }

    @GetMapping("/{id}")
    public String findById(@PathVariable Long id, Model model) {
        User user = userService.findById(id);
        model.addAttribute("user", user);
        return "user/detail";
    }

    @PostMapping
    public String insert(User user) {
        userService.insert(user);
        return "redirect:/users";
    }

    @PostMapping("/{id}/update")
    public String update(@PathVariable Long id, User user) {
        user.setId(id);
        userService.update(user);
        return "redirect:/users";
    }

    @PostMapping("/{id}/delete")
    public String delete(@PathVariable Long id) {
        userService.delete(id);
        return "redirect:/users";
    }
}
