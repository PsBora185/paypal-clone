package com.paypal.user_service.dto;

import lombok.Getter;

@Getter
public class SignupRequest {

    String name;

    String email;
    String password;
}
