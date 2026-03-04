package com.learnings.spring.mvc;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class EmployeeNotFoundException extends RuntimeException {
    public EmployeeNotFoundException(String message) {
        super(message);
    }
}
