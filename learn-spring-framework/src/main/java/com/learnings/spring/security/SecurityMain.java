package com.learnings.spring.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SecurityMain implements CommandLineRunner {

    @Autowired
    private EmployeeService employeeService;

    static void main(String[] args) {
        SpringApplication.run(SecurityMain.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        employeeService.registerEmployee("e1", "password1", "ADMIN");
        employeeService.registerEmployee("e2", "password2", "USER");
    }
}
