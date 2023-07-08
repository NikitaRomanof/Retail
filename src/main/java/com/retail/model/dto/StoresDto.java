package com.retail.model.dto;

import lombok.Data;

@Data
public class StoresDto {

    private Long id;
    private Long transactionStoreId;
    private Long skuId;
    private Long skuPurchasePrice;
    private Long skuRetailPrice;
}
