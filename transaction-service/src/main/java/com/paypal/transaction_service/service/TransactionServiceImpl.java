package com.paypal.transaction_service.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.paypal.transaction_service.dto.TransactionRequest;
import com.paypal.transaction_service.entity.Transaction;
import com.paypal.transaction_service.kafka.KafkaEventProducer;
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
    private final ObjectMapper objectMapper;
    private final KafkaEventProducer kafkaEventProducer;

    @Override
    public Transaction createtransaction(TransactionRequest request) {
        Transaction transaction = mapper.toEntity(request);
        transaction.setTimestamp(LocalDateTime.now());
        transaction.setStatus("PENDING");

        Transaction saved = repo.save(transaction);

        try{
            String payload = objectMapper.writeValueAsString(saved);
            String key = String.valueOf(saved.getId());
            kafkaEventProducer.sendTransactionEvent(key, payload);
            System.out.println("Kafka message sent.");
        } catch (JsonProcessingException e) {
            System.out.println("Failed to send Kafka event: "+e.getMessage());
        }
        return saved;
    }

    @Override
    public void updateStatus(Long id) {

    }

    @Override
    public List<Transaction> getAllTransactions() {
        return repo.findAll();
    }
}
