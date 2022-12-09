package com.JPA.cascade.bill.infrastructure.dto;

import com.JPA.cascade.client.infrastructure.dto.ClientOutputDTO;
import com.JPA.cascade.header.infrastructure.dto.HeaderOutputDTO;
import com.JPA.cascade.line.infrastructure.dto.LineOutputDTO;
import lombok.Data;

import java.util.List;

@Data
public class BillOutputDTO {
    private int id;
    private HeaderOutputDTO header;
    private ClientOutputDTO client;
    private List<LineOutputDTO> lines;
    private double billAmount;
}
