package com.github.gtbdemian.budgetapprovalsystem.mapper;

import com.github.gtbdemian.budgetapprovalsystem.domain.BudgetRequest;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface BudgetRequestMapper {
    List<BudgetRequest> findAll();
    BudgetRequest findById(Long id);
    void insert(BudgetRequest budgetRequest);
    void update(BudgetRequest budgetRequest);
    void delete(Long id);
    int countByUserIdAndStatus(@Param("userId") Long userId, @Param("status") String status);
}
