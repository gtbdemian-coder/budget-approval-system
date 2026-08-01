package com.github.gtbdemian.budgetapprovalsystem.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * 결재 이력 화면 표시용 DTO
 * MyBatis는 SQL 결과를 하나의 클래스에만 담을 수 있어서,
 * Approval(결재 정보) + Users(결재자 이름)를 JOIN한 결과를
 * 하나의 클래스에 담기 위해 별도 DTO를 생성하였습니다.
 */
@Getter
@Setter
public class ApprovalDto {
    private Long id;
    private Long budgetRequestId;
    private Long userId;
    private String userName;
    private String approvalStatus;
    private String approvalStep;
    private String comment;
    private LocalDateTime createdAt;
}
