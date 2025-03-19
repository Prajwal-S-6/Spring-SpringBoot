package com.learnings.learn_spring_framework.examples.a0;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.Arrays;



public class SimpleSpringContextInjectionLauncher {

    public static void main(String[] args) {

        try(var context = new AnnotationConfigApplicationContext(SpringConfiguration.class)) {

            System.out.println(context.getBean(BusinessClass.class));


        }


    }
}
