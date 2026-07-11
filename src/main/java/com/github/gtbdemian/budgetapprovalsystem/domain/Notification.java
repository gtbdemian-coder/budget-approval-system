package com.github.gtbdemian.budgetapprovalsystem.domain;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class Notification {
    private Long id;
    private Long userId;
    private Long budgetRequestId;
    private String message;
    private Boolean isRead;
    private LocalDateTime createdAt;
}
