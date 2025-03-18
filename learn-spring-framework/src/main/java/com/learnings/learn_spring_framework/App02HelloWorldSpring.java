package com.learnings.learn_spring_framework;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App02HelloWorldSpring {

    public static void main(String[] args) {
        //1. launch a spring context
        var context = new AnnotationConfigApplicationContext(HelloWorldConfiguration.class);

        //2. configure the things that we want spring to manage -in  @Configuration class
        // inside this we also created beans with @Bean config

        //retrieving beans
        Object name = context.getBean("myName");
        System.out.println(name);

        Object age = context.getBean("age");
        System.out.println(age);

        Object person = context.getBean("person");
        System.out.println(person);

        Object person2 = context.getBean("person2");
        System.out.println(person2);

        Object person3 = context.getBean(Person.class);
        System.out.println(person3);

        Object address = context.getBean(Address.class);
        System.out.println(address);
    }
}
