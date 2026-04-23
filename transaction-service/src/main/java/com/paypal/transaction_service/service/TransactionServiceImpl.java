package com.paypal.transaction_service.service;

import com.paypal.transaction_service.dto.TransactionRequest;
import com.paypal.transaction_service.entity.Transaction;
import com.paypal.transaction_service.repository.TransactionRepo;
import com.paypal.transaction_service.util.EntityMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class TransactionServiceImpl implements TransactionService {

    private final TransactionRepo repo;
    private final EntityMapper mapper;

    @Override
    public Transaction createtransaction(TransactionRequest request) {
        Transaction transaction = mapper.toEntity(request);
        transaction.setTimestamp(LocalDateTime.now());
        transaction.setStatus("PENDING");
        return repo.save(transaction);
    }

    @Override
    public void updateStatus(Long id) {

    }

    @Override
    public List<Transaction> getAllTransactions() {
        return repo.findAll();
    }
}
