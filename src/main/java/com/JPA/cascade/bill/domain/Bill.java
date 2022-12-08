package com.JPA.cascade.bill.domain;

import com.JPA.cascade.client.domain.Client;
import com.JPA.cascade.line.domain.Line;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter @Setter
@RequiredArgsConstructor
@Entity
@Table(name = "bill")
public class Bill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "amount", nullable = false)
    private double amount;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "client_id",
                nullable = false,
                unique = true)
    private Client client;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Line> line;
}