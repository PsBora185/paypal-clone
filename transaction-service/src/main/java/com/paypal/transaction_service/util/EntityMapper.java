package com.paypal.transaction_service.util;

import com.paypal.transaction_service.dto.TransactionRequest;
import com.paypal.transaction_service.dto.TransactionResponse;
import com.paypal.transaction_service.entity.Transaction;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper(componentModel = "spring")
public interface EntityMapper {

    TransactionResponse toDto(Transaction transaction);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "timestamp", ignore = true)
    @Mapping(target = "status", ignore = true)
    Transaction toEntity(TransactionRequest transactionRequest);
}
