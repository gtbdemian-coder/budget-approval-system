package com.github.gtbdemian.budgetapprovalsystem.mapper;

import com.github.gtbdemian.budgetapprovalsystem.domain.Approval;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ApprovalMapper {
    List<Approval> findByBudgetRequestId(Long budgetRequestId);
    Approval findById(Long id);
    void insert(Approval approval);
}
