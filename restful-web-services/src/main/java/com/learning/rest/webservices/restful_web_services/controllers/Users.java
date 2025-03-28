package com.learning.rest.webservices.restful_web_services.controllers;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;


public record Users(int id, @Size(min=2, message = "Name should be atleast 2 characters") @JsonProperty("user_name") String name, @Past(message = "Birth date cannot be future date") LocalDate birthDate) {


}
