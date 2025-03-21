package com.learning.springboot.learn_spring_boot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/")
public class CurrencyConfigurationController {

    @Autowired
    private CurrencyServiceConfiguration config;

    @GetMapping("/currency-configuration")
    // url to retrieve will be /spring/courses
    public CurrencyServiceConfiguration retrieveAllCourses() {
        return config;
    }

}
