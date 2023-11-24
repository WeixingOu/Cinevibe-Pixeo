package com.cinevibe.dtos;

import com.cinevibe.models.PurchaseDetail;
import com.cinevibe.models.Reserve;
import com.cinevibe.models.subclass.Customer;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class PurchaseDTO {
    private Long id;
    private Customer customer;
    private LocalDate date;
    private Double total;
    private Boolean paid;
    private Set<PurchaseDetail> purchaseDetails = new HashSet<>();
    private Set<Reserve> reserves = new HashSet<>();
}
