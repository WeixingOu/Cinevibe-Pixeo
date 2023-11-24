package com.cinevibe.repositories;

import com.cinevibe.models.subclass.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
