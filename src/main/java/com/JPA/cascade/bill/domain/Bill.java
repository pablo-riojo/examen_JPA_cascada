package com.JPA.cascade.bill.domain;

import com.JPA.cascade.client.domain.Client;
import com.JPA.cascade.line.domain.Line;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter @Setter
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "bill")
public class Bill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "amount")
    private double amount;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "client_id",
                nullable = false,
                unique = true)
    private Client client;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Line> line;
}