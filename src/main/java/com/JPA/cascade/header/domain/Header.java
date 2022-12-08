package com.JPA.cascade.header.domain;

import com.JPA.cascade.client.domain.Client;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter @Setter
@RequiredArgsConstructor
@Entity
@Table(name = "header")
public class Header {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne
    @JoinColumn(name = "client_id",
            nullable = false,
            unique = true)
    private Client client;

    @Column(name = "bill",
            nullable = false)
    private Double billAmount;
}