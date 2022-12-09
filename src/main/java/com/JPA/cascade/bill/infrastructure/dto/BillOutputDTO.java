package com.JPA.cascade.bill.infrastructure.dto;

import com.JPA.cascade.client.domain.Client;
import com.JPA.cascade.line.domain.Line;
import lombok.Data;

import java.util.List;

@Data
public class BillOutputDTO {
    private int id;
    private double amount;
    private Client client;
    private List<Line> lines;
}
