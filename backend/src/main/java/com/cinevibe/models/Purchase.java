package com.cinevibe.models;

import com.cinevibe.models.subclass.Customer;
import javax.persistence.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Purchase {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    private LocalDate date;
    private Double total;
    private Boolean paid;
    @OneToMany(mappedBy = "purchase")
    private Set<PurchaseDetail> purchaseDetails = new HashSet<>();

    @OneToMany(mappedBy = "purchase")
    private Set<Reserve> reserves = new HashSet<>();

    public Purchase() {}

    public Purchase(Customer customer, LocalDate date, Double total, Boolean paid, Set<PurchaseDetail> purchaseDetails, Set<Reserve> reserves) {
        this.customer = customer;
        this.date = date;
        this.total = total;
        this.paid = paid;
        this.purchaseDetails = purchaseDetails;
        this.reserves = reserves;
    }

    public Long getId() {
        return id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Set<PurchaseDetail> getPurchaseDetails() {
        return purchaseDetails;
    }

    public void setPurchaseDetails(Set<PurchaseDetail> purchaseDetails) {
        this.purchaseDetails = purchaseDetails;
    }

    public Boolean getPaid() {
        return paid;
    }

    public void setPaid(Boolean paid) {
        this.paid = paid;
    }

    public Set<Reserve> getReserves() {
        return reserves;
    }

    public void setReserves(Set<Reserve> reserves) {
        this.reserves = reserves;
    }
}
