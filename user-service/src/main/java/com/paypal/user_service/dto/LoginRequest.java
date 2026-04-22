package com.paypal.user_service.dto;

import lombok.Getter;

@Getter
public class LoginRequest {

    String email;
    String password;
}
