package com.cinevibe.models;

import com.cinevibe.enums.HALLTYPE;
import javax.persistence.*;
@Entity
public class Hall {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String number;
    private Integer capacity;
    private HALLTYPE type;

    public Hall() {}
    public Hall(String number, Integer capacity, HALLTYPE type) {
        this.number = number;
        this.capacity = capacity;
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public HALLTYPE getType() {
        return type;
    }

    public void setType(HALLTYPE type) {
        this.type = type;
    }
}
