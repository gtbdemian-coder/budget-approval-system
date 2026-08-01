package com.github.gtbdemian.budgetapprovalsystem.mapper;

import com.github.gtbdemian.budgetapprovalsystem.domain.Approval;
import com.github.gtbdemian.budgetapprovalsystem.dto.ApprovalDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ApprovalMapper {
    List<ApprovalDto> findByBudgetRequestId(Long budgetRequestId);
    void insert(Approval approval);
}
