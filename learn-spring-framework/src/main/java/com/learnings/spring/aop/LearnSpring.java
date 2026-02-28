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
public class LearnSpring implements ILearnSpring {

    public void method1() {
    }

    public int method2() {
        return 1;
    }

    public void method3(int arg1) {
    }

    public void method4(Person arg1) {
    }

    @SomeAnnotation2
    public void method5(Person arg1) {
    }

}
