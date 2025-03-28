package com.learning.rest.webservices.restful_web_services.versioning;

public class Personv1 {
    private String name;


    @Override
    public String toString() {
        return "Personv1{" +
                "name='" + name + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public Personv1(String name) {
        this.name = name;
    }
}
