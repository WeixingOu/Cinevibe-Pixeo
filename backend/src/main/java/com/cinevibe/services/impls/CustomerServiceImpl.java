package com.cinevibe.services.impls;

import com.cinevibe.dtos.CustomerDTO;
import com.cinevibe.models.subclass.Customer;
import com.cinevibe.repositories.CustomerRepository;
import com.cinevibe.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Customer getCustomerById(Long id) {
        return customerRepository.findById(id).orElse(null);
    }

    @Override
    public CustomerDTO getCustomerDTOById(Long id) {
        Optional<Customer> customer = customerRepository.findById(id);
        return customer.map(CustomerDTO::new).orElse(null);
    }

    @Override
    public CustomerDTO updateCustomer(Customer customer) {
        Customer customerUpt = customerRepository.save(customer);
        return new CustomerDTO(customerUpt);
    }
}
