package com.halim.model;

import javax.persistence.*;

@Entity
@Table(name = "usecart")
public class UserCart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;


}
