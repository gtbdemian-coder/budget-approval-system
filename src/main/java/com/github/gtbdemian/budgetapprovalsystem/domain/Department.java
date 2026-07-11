package com.github.gtbdemian.budgetapprovalsystem.domain;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class Department {
    private Long id;
    private String departmentName;
    private Long budgetLimit;
    private LocalDateTime createdAt;
}
