package com.learnings.spring.aop;

import org.springframework.stereotype.Component;

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
