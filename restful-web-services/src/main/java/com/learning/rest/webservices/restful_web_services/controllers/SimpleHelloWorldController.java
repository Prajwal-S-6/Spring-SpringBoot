package com.learning.rest.webservices.restful_web_services.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/restapi")
public class SimpleHelloWorldController {

    @GetMapping(value="hello")
    public String helloWorld() {
        return "Hello World";
    }

    @GetMapping(value="helloBean")
    public HelloWorldBean helloWorldBean() {
        return new HelloWorldBean("Hello");
    }


    @GetMapping(value="hello/{myname}")
    public HelloWorldBean helloWorldPathVariable(@PathVariable String myname) {
        return new HelloWorldBean(myname);
    }

}
