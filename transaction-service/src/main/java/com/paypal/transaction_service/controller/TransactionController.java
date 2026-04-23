package com.paypal.transaction_service.controller;


import com.paypal.transaction_service.dto.TransactionRequest;
import com.paypal.transaction_service.entity.Transaction;
import com.paypal.transaction_service.service.TransactionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/transactions")
@RequiredArgsConstructor
public class TransactionController {

    private final TransactionService service;

    @PostMapping("/create")
    public ResponseEntity<?> create(@Valid @RequestBody TransactionRequest request) {
        return ResponseEntity.ok(service.createtransaction(request));
    }

    @GetMapping
    public List<Transaction> getAll(){
        return service.getAllTransactions();
    }
}
