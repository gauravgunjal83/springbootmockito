package com.csi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {

    @Id
    @GeneratedValue

    private int empId;

    @Size(min = 2 , message = "must be 2 characters")
    private String empName;

    private String empAddress;

    private double empSalary;

    @Email(message = "EmailId Must be valid")
    private String empEmailId;
}
