package com.JPA.cascade.line.infrastructure.dto;

import com.JPA.cascade.bill.domain.Bill;
import lombok.Data;

@Data
public class LineOutputDTO {
    private Integer id;
    private String productName;
    private Double productPrice;
    private int productAmount;
}
