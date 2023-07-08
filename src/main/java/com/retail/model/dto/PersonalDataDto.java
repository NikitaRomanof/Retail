package com.retail.model.dto;

import lombok.Data;

@Data
public class PersonalDataDto {
    private Long customerId;
    private String customerName;
    private String customerSurname;
    private String customerPrimaryEmail;
    private Long customerPrimaryPhone;
}
