package com.learnings.spring.fundamentals;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main implements CommandLineRunner {

    @Autowired
    private SingletonBean singletonBean1;

    @Autowired
    private SingletonBean singletonBean2;

    @Autowired
    private PrototypeBean prototypeBean1;

    @Autowired
    private PrototypeBean prototypeBean2;

    static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
        System.out.println(singletonBean1);
        System.out.println(singletonBean2);
        System.out.println(prototypeBean1);
        System.out.println(prototypeBean2);
    }
}
