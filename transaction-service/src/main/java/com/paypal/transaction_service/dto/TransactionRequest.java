package com.paypal.transaction_service.dto;

import lombok.Getter;

@Getter
public class TransactionRequest {

    private Double amount;

    private Long senderId;

    private Long receiverId;
}
