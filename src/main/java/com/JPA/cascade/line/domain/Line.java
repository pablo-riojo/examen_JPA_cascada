package com.JPA.cascade.line.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter @Setter
@RequiredArgsConstructor
@Entity
@Table(name = "line")
public class Line {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "bill",
            nullable = false)
    private Integer billId;

    @Column(name = "product_name",
            nullable = false)
    private String productName;

    @Column(name = "product_price",
            nullable = false)
    private Double productPrice;

    @Column(name = "bill_amount")
    private Double billAmount;
}