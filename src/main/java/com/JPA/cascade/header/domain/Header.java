package com.JPA.cascade.header.domain;

import com.JPA.cascade.bill.domain.Bill;
import com.JPA.cascade.client.domain.Client;
import jakarta.persistence.*;
import lombok.*;

@Getter @Setter
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "header")
public class Header {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "bill_id")
    private Bill bill;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "client_id")
    private Client client;

    @Column(name = "bill")
    private Double billAmount;
}