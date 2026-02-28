package com.learnings.spring.aop;

import org.springframework.stereotype.Component;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@SomeAnnotation
class Person {
    String name;
    int age;

    public void personClassMethod() {
        System.out.println("PersonClassMethod");
    }
}

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@interface SomeAnnotation {

}

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@interface SomeAnnotation2 {

}

@Component
public class LearnSpringAOP implements IAop {

    public void method1() {
        System.out.println("Method1");
    }

    public int method2() {
        System.out.println("method2");
        return 1;
    }

    public void method3(int arg1) {
        System.out.println("method3");
    }

    public void method4(Person arg1) {
        System.out.println("method4");
    }

    @SomeAnnotation2
    public void method5(Person arg1) {
        System.out.println("method4");
    }

}
