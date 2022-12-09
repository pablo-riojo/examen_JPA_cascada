package com.JPA.cascade.line.infrastructure.dto;

import com.JPA.cascade.bill.domain.Bill;
import lombok.Data;

@Data
public class LineInputDTO {
    private String productName;
    private double productPrice;
    private int productAmount;
}
