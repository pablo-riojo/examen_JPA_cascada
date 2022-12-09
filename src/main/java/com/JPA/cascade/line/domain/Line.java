package com.JPA.cascade.line.domain;

import com.JPA.cascade.bill.domain.Bill;
import jakarta.persistence.*;
import lombok.*;

@Getter @Setter
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "line")
public class Line {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    private Bill bill;

    @Column(name = "product_name",
            nullable = false)
    private String productName;

    @Column(name = "product_price",
            nullable = false)
    private Double productPrice;

    @Column(name = "product_amount", nullable = false)
    private int productAmount = 1;
}