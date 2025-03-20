package com.learnings.learn_spring_framework.examples.a7xml;

import com.learnings.learn_spring_framework.game.GameRunner;
import com.learnings.learn_spring_framework.game.Pacman;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;

class ClassA {
    private ClassB classB;

    public ClassA(ClassB classB) {
        this.classB  = classB;
        System.out.println("this is XML based classA bean");
    }
}

class ClassB {

    public ClassB() {
        System.out.println("this is XML based classB bean");
    }
}
public class XMLConfigurationContextLauncher {

    public static void main(String[] args) {

        try(var context = new ClassPathXmlApplicationContext("contextConfiguration.xml")) {

            // Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
            //System.out.println(context.getBean(GameRunner.class));
            context.getBean(GameRunner.class).run();


        }


    }
}
