package com.paypal.transaction_service.service;

import com.paypal.transaction_service.dto.TransactionRequest;
import com.paypal.transaction_service.entity.Transaction;

import java.util.List;

public interface TransactionService {

    public Transaction createtransaction(TransactionRequest transactionRequest);

    public void updateStatus(Long id);

    public List<Transaction> getAllTransactions();
}
