package com.learnings.spring.aop;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@SomeAnnotation
@Component()
@Qualifier("PersonBean")
public class Person {
    String name;
    int age;

    public void personClassMethod() {
    }
}
