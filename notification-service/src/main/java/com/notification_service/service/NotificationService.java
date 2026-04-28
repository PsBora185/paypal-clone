package com.notification_service.service;

import com.notification_service.dto.NotifRequest;
import com.notification_service.entity.Notification;
import org.aspectj.weaver.ast.Not;

import java.util.List;

public interface NotificationService {

    Notification sendNotification(NotifRequest notification);

    List<Notification> getNotificationByUserId(Long id);
}
