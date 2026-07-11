package com.github.gtbdemian.budgetapprovalsystem.domain;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class BudgetRequest {
    private Long id;
    private Long userId;
    private Long budgetAmount;
    private String comment;
    private String title;
    private String status;
    private LocalDateTime createdAt;
}
