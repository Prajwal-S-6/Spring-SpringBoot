package com.learnings.spring.mvc;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "employee")
public class Employee {

    @Id
    public Integer id;

    public String name;

    public Integer salary;
}
