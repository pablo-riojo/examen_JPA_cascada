package com.JPA.cascade.bill.infrastructure.dto;

import com.JPA.cascade.client.infrastructure.dto.ClientOutputDTO;
import com.JPA.cascade.line.infrastructure.dto.LineOutputDTO;
import lombok.Data;

import java.util.List;

@Data
public class BillInputDTO {
    private double amount;
    private ClientOutputDTO client;
    private List<LineOutputDTO> lines;
}
