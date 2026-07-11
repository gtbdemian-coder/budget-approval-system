package com.github.gtbdemian.budgetapprovalsystem.domain;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class Approval {
    private Long id;
    private Long budgetRequestId;
    private Long userId;
    private String approvalStatus;
    private String approvalStep;
    private String comment;
    private LocalDateTime createdAt;
}
