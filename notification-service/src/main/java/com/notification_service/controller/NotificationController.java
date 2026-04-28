package com.notification_service.controller;

import com.notification_service.dto.NotifRequest;
import com.notification_service.entity.Notification;
import com.notification_service.service.NotificationService;
import lombok.RequiredArgsConstructor;
import org.aspectj.weaver.ast.Not;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/notify")
@RequiredArgsConstructor
public class NotificationController {

    private final NotificationService service;

    @PostMapping
    public Notification sendNotification(@RequestBody NotifRequest notifRequest){
        return service.sendNotification(notifRequest);
    }

    @GetMapping("/{userId}")
    public List<Notification> getNotificationByUser(@PathVariable Long userId){
        return service.getNotificationByUserId(userId);
    }
}
