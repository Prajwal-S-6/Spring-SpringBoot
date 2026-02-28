package com.learnings.spring.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/*
Pointcut expressions -

execution
within
args
this
target
bean

@annotation
@within
@args
@target

 */
@Aspect
@Component
public class AOP {

    private static final Logger logger = LoggerFactory.getLogger(AOP.class);

    @Before("execution(public void com.learnings.spring.aop.LearnSpring.*(..))")
    public void methodA(JoinPoint joinPoint){
        //logger.info("AOP -------------> Before method {}", joinPoint.getSignature().toShortString());
    }

    @After("within(*..spring.aop.Learn*) || within(*..spring.aop.Person)")
    public void methodB(JoinPoint joinPoint) {
        //logger.info("AOP -------------> After method {}", joinPoint.getSignature().toShortString());
    }

    @AfterReturning("execution(* *..*.LearnSpring.*(..)) && args(int)")
    public void methodC(JoinPoint joinPoint) {
        //logger.info("AOP -------------> After returning method {}", joinPoint.getSignature().toShortString());
    }

    //@After("this(LearnSpring)")
    // since jdk proxy is enabled during proxy spring creates another class on type ILearnSpring,
    // so LearnSpring wont match
    @After("this(ILearnSpring)")
    public void methodD(JoinPoint joinPoint) {
        //logger.info("AOP -------------> After method {}", joinPoint.getSignature().toShortString());
    }

    //@After("target(ILearnSpring)") //this works with target
    @After("target(LearnSpring)")
    public void methodE(JoinPoint joinPoint) {
        //logger.info("AOP -------------> After method {}", joinPoint.getSignature().toShortString());
    }

    //@After("bean(PersonBean)")
    @After("bean(person)") // class name is matched default naming convention class name first letter is lower case
    public void methodF(JoinPoint joinPoint) {
        //logger.info("AOP -------------> After method {}", joinPoint.getSignature().toShortString());
    }

    @After("@annotation(SomeAnnotation2)") // class name is matched default naming convention class name first letter is lower case
    public void methodG(JoinPoint joinPoint) {
        logger.info("AOP -------------> After method {}", joinPoint.getSignature().toShortString());
    }


}
