package com.learnings.learn_spring.helloworld;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

public class App02HelloWorldSpring {

    public static void main(String[] args) {
        //1. launch a spring context
        try(var context = new AnnotationConfigApplicationContext(HelloWorldConfiguration.class)) {
            //2. configure the things that we want spring to manage -in  @Configuration class
            // inside this we also created beans with @Bean config

            //retrieving beans
            Object name = context.getBean("myName");
            System.out.println(name);

            Object age = context.getBean("age");
            System.out.println(age);

            Object person = context.getBean(Person.class);
            System.out.println(person);

            Object person2 = context.getBean("person2");
            System.out.println(person2);

            Object person3 = context.getBean("person3");
            System.out.println(person3);

            Object person4 = context.getBean("person4");
            System.out.println(person4);

            Object address = context.getBean(Address.class);
            System.out.println(address);

            String[] beanNames = context.getBeanDefinitionNames();
            Arrays.stream(beanNames).forEach(System.out::println);
            System.out.println(context.getBeanDefinitionCount());
            System.out.println(context.getBeanDefinition("myName"));
        }
    }
}
