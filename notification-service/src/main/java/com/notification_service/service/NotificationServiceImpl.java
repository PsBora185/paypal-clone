package com.notification_service.service;

import com.notification_service.dto.NotifRequest;
import com.notification_service.entity.Notification;
import com.notification_service.repository.NotificationRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class NotificationServiceImpl implements NotificationService {

    private final NotificationRepo repo;

    @Override
    public Notification sendNotification(NotifRequest notif) {
        Notification notification = new Notification(notif.getMessage(), notif.getUserId(), LocalDateTime.now());
        return repo.save(notification);
    }

    @Override
    public List<Notification> getNotificationByUserId(Long id) {
        return repo.findByUserId(id);
    }
}
