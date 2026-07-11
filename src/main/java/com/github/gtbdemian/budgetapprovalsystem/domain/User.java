package com.github.gtbdemian.budgetapprovalsystem.domain;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class User {
    private Long id;
    private Long departmentId;
    private String name;
    private String employeeNumber;
    private String title;
    private String role;
    private String email;
    private String password;
    private LocalDateTime createdAt;
}
