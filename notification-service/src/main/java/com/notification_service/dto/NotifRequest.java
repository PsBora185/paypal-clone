package com.notification_service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class NotifRequest {

    private String message;
    private Long userId;
}
