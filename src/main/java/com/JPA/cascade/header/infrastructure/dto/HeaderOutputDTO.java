package com.JPA.cascade.header.infrastructure.dto;

import com.JPA.cascade.bill.domain.Bill;
import lombok.Data;

@Data
public class HeaderOutputDTO {
    private Double billAmount;
    private Integer clientId;
}
