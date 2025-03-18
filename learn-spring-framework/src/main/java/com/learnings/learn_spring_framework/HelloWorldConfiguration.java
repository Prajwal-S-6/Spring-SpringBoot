package com.learnings.learn_spring_framework;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HelloWorldConfiguration {

    @Bean
    public String name() {
        return "Prajwal";
    }

    @Bean
    public int age() {
        return 25;
    }

}
