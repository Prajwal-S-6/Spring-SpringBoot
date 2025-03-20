package com.learnings.learn_spring_framework.examples.a3;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Lazy
class classA {
    public classA() {
        System.out.println("class A initialization");
    }
}

@Component
@Lazy
class classB {
    private classA classA;
    public classB(classA classA) {
        System.out.println("class B initialization");
        this.classA = classA;
    }
}

@Configuration
@ComponentScan
public class LazyInitializationLauncher {

    public static void main(String[] args) {

        try(var context = new AnnotationConfigApplicationContext(LazyInitializationLauncher.class)) {

            context.getBean(classB.class);
            context.getBean(classA.class);


        }


    }
}
