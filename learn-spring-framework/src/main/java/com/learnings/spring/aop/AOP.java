package com.learnings.spring.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

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
        logger.info("AOP -------------> After returning method {}", joinPoint.getSignature().toShortString());
    }
}
