package com.learnings.learn_spring_framework.examples.a5;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
class SomeClass {
    private SomeDpendency dpendency;
    public SomeClass(SomeDpendency dpendency) {
        this.dpendency = dpendency;
    }

    @PostConstruct
    private void initialize() {
        System.out.println("after all dependency are wired for bean 1");
        dpendency.getready();
    }

    @PreDestroy
    private void destroy() {
        System.out.println("before bean 1 is removed from IOC container");
    }

}

@Component
class SomeDpendency {

    @PostConstruct
    private void initialize() {
        System.out.println("after all dependency are wired for bean 2");
    }

    public void getready() {
        System.out.println("Some logic using some dependency");
    }

    @PreDestroy
    private void destroy() {
        System.out.println("before bean 2 is removed from IOC container");
    }
}

@Configuration
@ComponentScan
public class PrePostAnnotationContextLauncher {

    public static void main(String[] args) {

        try(var context = new AnnotationConfigApplicationContext(PrePostAnnotationContextLauncher.class)) {

            context.getBean(SomeClass.class);



        }


    }
}
