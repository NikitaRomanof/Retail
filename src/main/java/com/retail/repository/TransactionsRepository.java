package com.retail.repository;

import com.retail.model.entity.Transactions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TransactionsRepository extends JpaRepository<Transactions, Long> {
    Optional<Transactions> findTransactionsByTransactionId(Long transactionId);
}
