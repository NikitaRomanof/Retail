package com.retail.service;

import com.retail.model.entity.Sku;
import com.retail.model.entity.Transactions;
import com.retail.repository.TransactionsRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionsService {
    private final TransactionsRepository repository;

    public TransactionsService(TransactionsRepository repository) {
        this.repository = repository;
    }

    public List<Transactions> getAllTransactions() {
        return repository.findAll();
    }

    public Transactions getByIdOrElseThrow(Long id) {
        return repository.findTransactionsByTransactionId(id)
                .orElseThrow(() -> new IllegalArgumentException(
                        String.format("Transactions with id '%d' not found", id)));
    }

}
