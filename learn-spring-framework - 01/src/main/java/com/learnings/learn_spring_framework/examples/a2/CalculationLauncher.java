package com.learnings.learn_spring_framework.examples.a2;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class CalculationLauncher {

    public static void main(String[] args) {
        try(var context = new AnnotationConfigApplicationContext(BusinessCalculationService.class)) {
            var bean = context.getBean(BusinessCalculationService.class);
            System.out.println(bean.findMax());
        }
    }
}
