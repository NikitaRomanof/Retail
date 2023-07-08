package com.retail.model.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "transactions", schema = "public")
public class Transactions {
    @Id
    @GeneratedValue
    @Column(name = "transaction_id")
    private Long transactionId;
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "customer_card_id", referencedColumnName = "customer_card_id", nullable = false)
    private Card cardId;
    @Column(name = "transaction_summ", nullable = false)
    private Long transactionSumm;
    @Column(name = "transaction_date_time")
    private LocalDate date;
    @Column(name = "transaction_store_id")
    private Long transactionStoreId;

    public Transactions() {
    }

    public Transactions(Long transactionId, Card cardId, Long transactionSumm, LocalDate date, Long transactionStoreId) {
        this.transactionId = transactionId;
        this.cardId = cardId;
        this.transactionSumm = transactionSumm;
        this.date = date;
        this.transactionStoreId = transactionStoreId;
    }

    public Long getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Long transactionId) {
        this.transactionId = transactionId;
    }

    public Card getCardId() {
        return cardId;
    }

    public void setCardId(Card cardId) {
        this.cardId = cardId;
    }

    public Long getTransactionSumm() {
        return transactionSumm;
    }

    public void setTransactionSumm(Long transactionSumm) {
        this.transactionSumm = transactionSumm;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Long getTransactionStoreId() {
        return transactionStoreId;
    }

    public void setTransactionStoreId(Long transactionStoreId) {
        this.transactionStoreId = transactionStoreId;
    }
}
