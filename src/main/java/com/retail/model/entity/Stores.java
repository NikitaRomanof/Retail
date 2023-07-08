package com.retail.model.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "stores", schema = "public")
public class Stores {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;
    @Column(name = "transaction_store_id", nullable = false)
    private Long transactionStoreId;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "sku_id", referencedColumnName = "sku_id", nullable = false)
    private Sku skuId;
    @Column(name = "sku_purchase_price", nullable = false)
    private Long skuPurchasePrice;
    @Column(name = "sku_retail_price", nullable = false)
    private Long skuRetailPrice;

    public Stores() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTransactionStoreId() {
        return transactionStoreId;
    }

    public void setTransactionStoreId(Long transactionStoreId) {
        this.transactionStoreId = transactionStoreId;
    }

    public Sku getSkuId() {
        return skuId;
    }

    public void setSkuId(Sku skuId) {
        this.skuId = skuId;
    }

    public Long getSkuPurchasePrice() {
        return skuPurchasePrice;
    }

    public void setSkuPurchasePrice(Long skuPurchasePrice) {
        this.skuPurchasePrice = skuPurchasePrice;
    }

    public Long getSkuRetailPrice() {
        return skuRetailPrice;
    }

    public void setSkuRetailPrice(Long skuRetailPrice) {
        this.skuRetailPrice = skuRetailPrice;
    }
}
