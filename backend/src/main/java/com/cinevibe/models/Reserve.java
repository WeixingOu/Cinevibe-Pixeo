package com.cinevibe.models;

import javax.persistence.*;
@Entity
public class Reserve {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "function_id")
    private Function function;

    @ManyToOne
    @JoinColumn(name = "seat_id")
    private Seat seat;

    public Reserve() {}
    public Reserve(Function function, Seat seat) {
        this.function = function;
        this.seat = seat;
    }

    public Long getId() {
        return id;
    }

    public Function getFunction() {
        return function;
    }

    public void setFunction(Function function) {
        this.function = function;
    }

    public Seat getSeat() {
        return seat;
    }

    public void setSeat(Seat seat) {
        this.seat = seat;
    }
}
