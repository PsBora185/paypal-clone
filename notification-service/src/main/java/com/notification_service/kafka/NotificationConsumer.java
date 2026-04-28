package com.notification_service.kafka;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.notification_service.dto.NotifRequest;
import com.notification_service.entity.Notification;
import com.notification_service.entity.Transaction;
import com.notification_service.repository.NotificationRepo;
import com.notification_service.service.NotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.time.LocalTime;


@Component
@RequiredArgsConstructor
public class NotificationConsumer {

    private final NotificationService service;

    private final ObjectMapper mapper;

    @KafkaListener(topics = "txn-initiated", groupId = "notification-group")
    public void listener(String msg) {
        try {
            Transaction txn = mapper.readValue(msg, Transaction.class);
            String message = "Received " + txn.getAmount() + " from " + txn.getSenderId();
            NotifRequest notifRequest = new NotifRequest(message, txn.getReceiverId());
            service.sendNotification(notifRequest);
            System.out.println("\nKafka message received and notification sent at "+ LocalTime.now() +".\n");
        } catch (JsonProcessingException e) {
            System.out.println("\nFailed kafka : " + e.getMessage());
        }
    }
}
