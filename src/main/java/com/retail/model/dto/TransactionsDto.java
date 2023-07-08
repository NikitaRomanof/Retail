package com.retail.model.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class TransactionsDto {

    private Long transactionId;
    private Long cardId;
    private Long transactionSumm;
    private LocalDate date;
    private Long transactionStoreId;
}
