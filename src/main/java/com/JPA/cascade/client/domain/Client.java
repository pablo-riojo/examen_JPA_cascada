package com.JPA.cascade.client.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter @Setter
@RequiredArgsConstructor
@Entity
@Table(name = "client")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name",
            nullable = false)
    private String name;

    // TODO: necessary?
//    @OneToOne(mappedBy = "client")
//    private Bill bill;
//
//    @OneToOne(mappedBy = "client")
//    private Header header;
}