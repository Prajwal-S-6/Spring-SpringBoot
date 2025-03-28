package com.learning.rest.webservices.restful_web_services.versioning;

public class Name {
    private String firstName;
    private String lastName;

    public String getFirstName() {
        return firstName;
    }

    public Name(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getLastName() {
        return lastName;
    }
}
