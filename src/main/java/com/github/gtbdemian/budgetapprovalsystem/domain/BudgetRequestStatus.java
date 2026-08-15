package com.github.gtbdemian.budgetapprovalsystem.domain;

/**
 * 예산신청서 상태
 *
 * 상태를 ENUM으로 관리하여 오타방지 및 타입안정성을 확보함
 *
 * PENDING: 결제 대기중 (신청서 최초 등록 시 기본값)
 * APPROVED 승인 완료
 * REJECTED 반려
 */
public enum BudgetRequestStatus {
    PENDING, APPROVED, REJECTED
}
