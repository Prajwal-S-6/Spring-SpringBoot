package com.learnings.learn_spring_framework.examples.a0;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
class BusinessClass {

    // field -based DI
//    @Autowired
//    Dependency1 dependency1;
//    @Autowired
//    Dependency2 dependency2;


    private Dependency1 dependency1;
    private Dependency2 dependency2;

    // constructor based DI
    public BusinessClass(Dependency1 dependency1, Dependency2 dependency2) {
        System.out.println("Constructor based DI");
        this.dependency1 = dependency1;
        this.dependency2 = dependency2;
    }

    //setter-based DI
//    @Autowired
//    public void setDependency1(Dependency1 dependency1) {
//        this.dependency1 = dependency1;
//    }
//
//    @Autowired
//    public void setDependency2(Dependency2 dependency2) {
//        this.dependency2 = dependency2;
//    }

    @Override
    public String toString() {
        return "using " +
                dependency1 +
                " and " +
                dependency2;
    }

}

@Component
class Dependency1 {

}

@Component
class Dependency2{

}

@Configuration
@ComponentScan
public class SpringConfiguration {

}
