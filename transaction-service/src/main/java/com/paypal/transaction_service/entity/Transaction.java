package com.paypal.transaction_service.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    @Column(nullable = false)
    private Long senderId;

    @Column(nullable = false)
    private Long receiverId;

    @Column(nullable = false)
    @Positive(message = "Amount must be positive")
    private Double amount;

    @Column(nullable = false)
    private LocalDateTime timestamp;

    @Column(nullable = false)
    private String status;

    @PrePersist
    private void prePersist() {
        if (timestamp == null)
            timestamp = LocalDateTime.now();
        if (status == null)
            status = "PENDING";
    }

    @Override
    public String toString() {
        return "Transaction : " +
                "id : " + id +
                ", Sender : " + senderId +
                ", Receiver : " + receiverId +
                ", Amount : " + amount +
                ", Time : " + timestamp +
                ", Status : " + status;

    }
}
