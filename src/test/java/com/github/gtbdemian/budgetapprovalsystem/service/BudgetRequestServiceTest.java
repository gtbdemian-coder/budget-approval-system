package com.github.gtbdemian.budgetapprovalsystem.service;

import com.github.gtbdemian.budgetapprovalsystem.domain.BudgetRequest;
import com.github.gtbdemian.budgetapprovalsystem.mapper.BudgetRequestMapper;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class BudgetRequestServiceTest {

    @Mock
    private BudgetRequestMapper budgetRequestMapper;

    @InjectMocks
    private BudgetRequestService budgetRequestService;

    @Test
    @DisplayName("전체 조회")
    void findAll() {

        //given
        BudgetRequest request = new BudgetRequest();
        request.setId(1L);
        request.setTitle("노트북 구매");
        Mockito.when(budgetRequestMapper.findAll()).thenReturn(List.of(request));

        //when
        List<BudgetRequest> result = budgetRequestService.findAll();

        //then
        assertThat(result).hasSize(1);
        assertThat(result.get(0).getTitle()).isEqualTo("노트북 구매");

    }

    @Test
    @DisplayName("아이디 조회")
    void findById() {

        //given
        BudgetRequest request = new BudgetRequest();
        request.setId(1L);
        request.setTitle("노트북 구매");
        Mockito.when(budgetRequestService.findById(1L)).thenReturn(request);

        //when
        BudgetRequest result = budgetRequestService.findById(1L);

        //then
        assertThat(result.getId()).isEqualTo(1L);
        assertThat(result.getTitle()).isEqualTo("노트북 구매");

    }

    @Test
    @DisplayName("사용자 ID와 상태정보로 예산신청서 신청 건수 조회")
    void countByUserIdAndStatus() {

        //given
        Mockito.when(budgetRequestMapper.countByUserIdAndStatus(1L, "PENDING")).thenReturn(2);

        //when
        int result = budgetRequestService.countByUserIdAndStatus(1L, "PENDING");

        //then
        assertThat(result).isEqualTo(2);
    }

    @Test
    @DisplayName("예산신청서 등록")
    void insert() {

        //given
        BudgetRequest request = new BudgetRequest();
        request.setId(1L);
        request.setTitle("노트북 구매");
        request.setStatus("PENDING");

        //when
        budgetRequestService.insert(request);

        //then
        Mockito.verify(budgetRequestMapper).insert(request);

    }

    @Test
    @DisplayName("예산신청서 수정")
    void update() {

        //given
        BudgetRequest request = new BudgetRequest();
        request.setId(1L);
        request.setTitle("노트북 구매");
        request.setStatus("PENDING");

        //when
        budgetRequestService.update(request);


        //then
        Mockito.verify(budgetRequestMapper).update(request);
    }

    @Test
    @DisplayName("예산신청서 삭제")
    void delete() {

        //given
        Long id = 1L;

        //when
        budgetRequestService.delete(id);

        //then
        Mockito.verify(budgetRequestMapper).delete(id);
    }
}
