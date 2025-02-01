package com.managment.Employee.model;

import jakarta.persistence.*;
import org.springframework.lang.NonNull;


@Entity
@Table
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer emoloyeeID;

    @NonNull
    private String name;

    @NonNull
    private String email;
    private String position;
    private float salary;

    public Integer getEmoloyeeID() {
        return emoloyeeID;
    }

    public void setEmoloyeeID(Integer emoloyeeID) {
        this.emoloyeeID = emoloyeeID;
    }

    @NonNull
    public String getName() {
        return name;
    }

    public void setName(@NonNull String name) {
        this.name = name;
    }

    @NonNull
    public String getEmail() {
        return email;
    }

    public void setEmail(@NonNull String email) {
        this.email = email;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }
}

