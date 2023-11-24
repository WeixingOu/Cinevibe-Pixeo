package com.cinevibe.models.subclass;

import com.cinevibe.models.supclass.User;
import javax.persistence.Entity;
import java.time.LocalDate;
import java.util.Date;

@Entity
public class Employee extends User {
    public Employee() {
    }

    public Employee(String name, String email, String phone, String password, LocalDate birthdate, LocalDate createdDate, boolean active) {
        super(name, email, phone, password, birthdate, createdDate, active);
    }
}
