package com.cinevibe.dtos;

import com.cinevibe.models.subclass.Customer;
import com.cinevibe.validators.Birthdate;

import javax.validation.constraints.*;

import java.time.LocalDate;

public class CustomerDTO {
    private Long id;
    @NotBlank
    private String name;
    @NotBlank
    private String phone;
    @NotBlank
    @Email
    private String email;
    @NotNull
    @Past
    @Birthdate
    private LocalDate birthdate;
    private LocalDate createdDate;

    public CustomerDTO() {
    }

    public CustomerDTO(Customer customer) {
        this.id = customer.getId();
        this.name = customer.getName();
        this.phone = customer.getPhone();
        this.email = customer.getEmail();
        this.createdDate = customer.getCreatedDate();
        this.birthdate = customer.getBirthdate();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public LocalDate getCreatedDate() {
        return createdDate;
    }
}
