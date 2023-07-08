package com.retail.model.entity;


import jakarta.persistence.*;

@Entity
@Table(name = "transaction_id", schema = "public")
public class Checks {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "transaction_id", referencedColumnName = "transaction_id", nullable = false)
    private Transactions transactionId;
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "sku_id", referencedColumnName = "sku_id", nullable = false)
    private Sku skuId;
    @Column(name = "sku_amount", nullable = false)
    private Long skuAmount;
    @Column(name = "sku_summ", nullable = false)
    private Long skuSumm;
    @Column(name = "sku_summ_paid", nullable = false)
    private Long skuSummPaid;
    @Column(name = "sku_discount", nullable = false)
    private Long skuDiscount;

    public Checks() {
    }

    public Checks(Long id, Transactions transactionId, Sku skuId, Long skuAmount, Long skuSumm, Long skuSummPaid, Long skuDiscount) {
        this.id = id;
        this.transactionId = transactionId;
        this.skuId = skuId;
        this.skuAmount = skuAmount;
        this.skuSumm = skuSumm;
        this.skuSummPaid = skuSummPaid;
        this.skuDiscount = skuDiscount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Transactions getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Transactions transactionId) {
        this.transactionId = transactionId;
    }

    public Sku getSkuId() {
        return skuId;
    }

    public void setSkuId(Sku skuId) {
        this.skuId = skuId;
    }

    public Long getSkuAmount() {
        return skuAmount;
    }

    public void setSkuAmount(Long skuAmount) {
        this.skuAmount = skuAmount;
    }

    public Long getSkuSumm() {
        return skuSumm;
    }

    public void setSkuSumm(Long skuSumm) {
        this.skuSumm = skuSumm;
    }

    public Long getSkuSummPaid() {
        return skuSummPaid;
    }

    public void setSkuSummPaid(Long skuSummPaid) {
        this.skuSummPaid = skuSummPaid;
    }

    public Long getSkuDiscount() {
        return skuDiscount;
    }

    public void setSkuDiscount(Long skuDiscount) {
        this.skuDiscount = skuDiscount;
    }
}
