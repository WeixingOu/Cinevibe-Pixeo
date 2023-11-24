package com.cinevibe.controllers;

import com.cinevibe.dtos.CustomerDTO;
import com.cinevibe.dtos.PurchaseDTO;
import com.cinevibe.dtos.ReserveDTO;
import com.cinevibe.models.Purchase;
import com.cinevibe.models.Reserve;
import com.cinevibe.models.subclass.Customer;
import com.cinevibe.services.CustomerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;
import java.util.Set;

import static com.cinevibe.utils.CustomerUtils.*;

@RestController
@RequestMapping("/api")
public class CustomerController {
    private static final String CUSTOMER_FOUND_MESSAGE = "Customer found";
    private static final String CUSTOMER_NOT_FOUND_MESSAGE = "Customer not found";
    private static final String CUSTOMER_UPDATED_SUCCESS_MESSAGE = "Customer updated successfully";

    @Autowired
    private CustomerService customerService;
    @GetMapping("/customers/{id}")
    public ResponseEntity<Object> getCustomer(@PathVariable Long id) {
        CustomerDTO customerDTO = customerService.getCustomerDTOById(id);
        if (customerDTO == null) {
            Map<String, Object> ApiResponse = ResponseEntity(id, customerDTO, CUSTOMER_NOT_FOUND_MESSAGE, HttpStatus.NOT_FOUND);

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ApiResponse);
        } else {
            Map<String, Object> ApiResponse = ResponseEntity(id, customerDTO, CUSTOMER_FOUND_MESSAGE, HttpStatus.OK);

            return ResponseEntity.ok().body(ApiResponse);
        }
    }

    @PutMapping("/customers/{id}")
    public ResponseEntity<Object> updateCustomer(@PathVariable Long id, @Valid @RequestBody CustomerDTO customerDTO) {
        Customer customer = customerService.getCustomerById(id);
        if (customer == null) {
            Map<String, Object> ApiResponse = ResponseEntity(id, customerDTO, CUSTOMER_NOT_FOUND_MESSAGE, HttpStatus.NOT_FOUND);

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ApiResponse);
        } else  {
            customer.setName(customerDTO.getName());
            customer.setPhone(customerDTO.getPhone());
            customer.setEmail(customerDTO.getEmail());
            customer.setBirthdate(customerDTO.getBirthdate());

            CustomerDTO customerUpt = customerService.updateCustomer(customer);

            Map<String, Object> ApiResponse = ResponseEntity(id, customerUpt, CUSTOMER_UPDATED_SUCCESS_MESSAGE, HttpStatus.OK);

            return ResponseEntity.ok().body(ApiResponse);
        }
    }

    @PostMapping("/customers/{id}/purchases")
    public ResponseEntity<Object> createPurchase(@PathVariable Long id, @Valid @RequestBody PurchaseDTO purchaseDTO, @Valid @RequestBody Set<ReserveDTO> reserveDTOs) {
        Customer customer = customerService.getCustomerById(id);

        CustomerDTO customerDTO = customerService.getCustomerDTOById(id);

        if (customerDTO == null || customer == null) {
            Map<String, Object> ApiResponse = ResponseEntity(id, customerDTO, CUSTOMER_NOT_FOUND_MESSAGE, HttpStatus.NOT_FOUND);

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ApiResponse);
        } else  {
            Purchase purchase = new Purchase();
            purchase.setCustomer(customer);


        }
    }
}