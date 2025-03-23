package com.learning.springboot.project.todo_webapp.services;

import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    public boolean authenticateUser(String name, String password) {
        return name.equals("Prajwal") && password.equals("password");
    }
}
