package com.retail.model.dto;

import lombok.Data;

@Data
public class ChecksDto {
    private Long id;
    private Long transactionId;
    private Long skuId;
    private Long skuAmount;
    private Long skuSumm;
    private Long skuSummPaid;
    private Long skuDiscount;
}
