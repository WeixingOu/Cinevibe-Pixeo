package com.cinevibe.models.supclass;

import javax.persistence.*;

import java.time.LocalDate;

@Entity
@Inheritance( strategy = InheritanceType.JOINED )
@Table(name = "cinevibe_user")
public abstract class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name, email, phone, password;
    private LocalDate birthdate, createdDate;
    private boolean active;

    protected User() {}
    protected User(String name, String email, String phone, String password, LocalDate birthdate, LocalDate createdDate, boolean active) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.password = password;
        this.birthdate = birthdate;
        this.createdDate = createdDate;
        this.active = active;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDate createdDate) {
        this.createdDate = createdDate;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
