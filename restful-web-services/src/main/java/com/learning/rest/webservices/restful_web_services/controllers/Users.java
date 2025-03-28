package com.learning.rest.webservices.restful_web_services.controllers;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;


public class Users {

    private int id;
    @Size(min=2, message = "Name should be atleast 2 characters") @JsonProperty("user_name") private String name;
    @Past(message = "Birth date cannot be future date") private LocalDate birthDate;

    public Users(int id, String name, LocalDate birthDate) {
        this.name = name;
        this.id = id;
        this.birthDate = birthDate;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }
}
