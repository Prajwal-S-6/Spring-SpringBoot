package com.learnings.spring.aop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.aop.AopAutoConfiguration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication(exclude = AopAutoConfiguration.class)
@EnableAspectJAutoProxy(proxyTargetClass = false)
public class Application implements CommandLineRunner {

    @Autowired
    private ILearnSpring learnSpring;

    @Autowired
    private Person person; // use Spring-managed Person bean so AOP can proxy it

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        learnSpring.method1();
        learnSpring.method2();
        learnSpring.method3(2);
        learnSpring.method4(new Person());
        learnSpring.method5(new Person());
        // call the Spring-managed bean so AOP advice is applied
        person.personClassMethod();
    }
}
