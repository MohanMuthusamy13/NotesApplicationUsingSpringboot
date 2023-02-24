package com.example.Notes_Application.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@Entity
@Getter
@Setter
@ToString
@Table(name = "employee_table")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @NotNull(message = "Name should not be null") @NotEmpty(message = "Name should not be empty")
    @NotBlank(message = "Name should not be blank")
    private String name;

    @NotNull(message = "Age should not be null")
    private Long age;

    private String location;

    @Email(message = "Enter the correct email address")
    private String email;

    @NotNull(message = "Department should not be null") @NotEmpty(message = "Department should not be empty")
    private String department;

    @CreationTimestamp
    @Column(name = "creation_date", nullable = false, updatable = false)
    private Date createdAt;

    @UpdateTimestamp
    @Column(name = "update_date", nullable = false)
    private Date updatedAt;
}