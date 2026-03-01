package com.learnings.spring.fundamentals;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main implements CommandLineRunner {

    @Autowired
    private BeanA beanA1;

    @Autowired
    private BeanA beanA2;

    @Autowired
    private BeanB beanB1;

    @Autowired
    private BeanB beanB2;

    static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
        System.out.println(beanA1);
        System.out.println(beanA2);
        System.out.println(beanB1);
        System.out.println(beanB2);
    }
}
