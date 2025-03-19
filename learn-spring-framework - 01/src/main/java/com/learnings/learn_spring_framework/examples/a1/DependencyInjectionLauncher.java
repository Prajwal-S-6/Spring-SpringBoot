package com.learnings.learn_spring_framework.examples.a1;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;


@Configuration

@ComponentScan
public class DependencyInjectionLauncher {

    public static void main(String[] args) {

        try(var context = new AnnotationConfigApplicationContext(DependencyInjectionLauncher.class)) {

            Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);


        }


    }
}
