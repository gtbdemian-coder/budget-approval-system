package com.github.gtbdemian.budgetapprovalsystem.mapper;

import com.github.gtbdemian.budgetapprovalsystem.domain.Notification;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface NotificationMapper {
    List<Notification> findByUserId(Long userId);
    void insert(Notification notification);
    void updateIsRead(Long id);
}
