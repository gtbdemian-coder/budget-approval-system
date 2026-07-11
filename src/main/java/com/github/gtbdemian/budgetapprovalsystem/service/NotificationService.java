package com.github.gtbdemian.budgetapprovalsystem.service;

import com.github.gtbdemian.budgetapprovalsystem.domain.Notification;
import com.github.gtbdemian.budgetapprovalsystem.mapper.NotificationMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificationService {

    private final NotificationMapper notificationMapper;

    public NotificationService(NotificationMapper notificationMapper) {
        this.notificationMapper = notificationMapper;
    }

    public List<Notification> findByUserId(Long userId) {
        return notificationMapper.findByUserId(userId);
    }

    public void insert(Notification notification) {
        notificationMapper.insert(notification);
    }

    public void updateIsRead(Long id) {
        notificationMapper.updateIsRead(id);
    }
}
