package com.learnings.spring.aop;

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
    public void methodA(){
        logger.info("Before method");
    }
}
