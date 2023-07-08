package com.retail.model.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "personal_data", schema = "public")
public class PersonalData {
    @Id
    @GeneratedValue
    @Column(name = "customer_id")
    private Long customerId;
    @Column(name = "customer_name", nullable = false)
    private String customerName;
    @Column(name = "customer_surname", nullable = false)
    private String customerSurname;
    @Column(name = "customer_primary_email", nullable = false)
    private String customerPrimaryEmail;
    @Column(name = "customer_primary_phone", nullable = false)
    private Long customerPrimaryPhone;

    public PersonalData() {
    }

    public PersonalData(Long customerId, String customerName, String customerSurname, String customerPrimaryEmail, Long customerPrimaryPhone) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.customerSurname = customerSurname;
        this.customerPrimaryEmail = customerPrimaryEmail;
        this.customerPrimaryPhone = customerPrimaryPhone;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerSurname() {
        return customerSurname;
    }

    public void setCustomerSurname(String customerSurname) {
        this.customerSurname = customerSurname;
    }

    public String getCustomerPrimaryEmail() {
        return customerPrimaryEmail;
    }

    public void setCustomerPrimaryEmail(String customerPrimaryEmail) {
        this.customerPrimaryEmail = customerPrimaryEmail;
    }

    public Long getCustomerPrimaryPhone() {
        return customerPrimaryPhone;
    }

    public void setCustomerPrimaryPhone(Long customerPrimaryPhone) {
        this.customerPrimaryPhone = customerPrimaryPhone;
    }
}
