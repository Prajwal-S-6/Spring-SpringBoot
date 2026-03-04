package com.learnings.spring.mvc;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee2")
public class EmployeeController2 {

    @GetMapping
    public void getEmployee2() {
        throw new EmployeeNotFoundException();
    }
}
