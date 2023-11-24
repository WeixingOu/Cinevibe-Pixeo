package com.cinevibe.models;

import javax.persistence.*;
@Entity
public class Seat {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String number;
    private Boolean status;
    @ManyToOne
    @JoinColumn(name = "hall_id")
    private Hall hall;
}
