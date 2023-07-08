package com.retail.model.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "cards", schema = "public")
public class Card {
    @Id
    @GeneratedValue
    @Column(name = "customer_card_id")
    private Long customerCardId;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "customer_id", referencedColumnName = "customer_id", nullable = false)
    private PersonalData customerId;

    public Card(Long customerCardId, PersonalData customerId) {
        this.customerCardId = customerCardId;
        this.customerId = customerId;
    }

    public Card() {
    }

    public Long getCustomerCardId() {
        return customerCardId;
    }

    public void setCustomerCardId(Long customerCardId) {
        this.customerCardId = customerCardId;
    }

    public PersonalData getCustomerId() {
        return customerId;
    }

    public void setCustomerId(PersonalData customerId) {
        this.customerId = customerId;
    }
}
