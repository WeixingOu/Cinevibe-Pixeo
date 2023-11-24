package com.cinevibe.services;

import com.cinevibe.dtos.CustomerDTO;
import com.cinevibe.models.subclass.Customer;

public interface CustomerService {
    Customer getCustomerById(Long id);
    CustomerDTO getCustomerDTOById(Long id);
    CustomerDTO updateCustomer(Customer customer);
}
