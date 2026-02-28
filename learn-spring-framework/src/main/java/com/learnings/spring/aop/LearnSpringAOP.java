package com.learnings.spring.aop;

import org.springframework.stereotype.Component;

class Person {
    String name;
    int age;
}

@Component
public class LearnSpringAOP {

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


}
