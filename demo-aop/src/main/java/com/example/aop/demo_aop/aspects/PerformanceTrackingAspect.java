package com.example.aop.demo_aop.aspects;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Configuration
@Aspect
public class PerformanceTrackingAspect {
    private Logger LOG = LoggerFactory.getLogger(getClass());

    @Around("com.example.aop.demo_aop.aspects.CommonPointcutConfig.commonConfigUsingAnnotation()")
    public Object findExecutionTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        //start timer
        long startTime = System.currentTimeMillis();
        //execute method
        Object returnValue = proceedingJoinPoint.proceed();

        //stop timer
        long stopTime = System.currentTimeMillis();
        long executionDuration = stopTime - startTime;
        LOG.info("{} Method Execution time is {}", proceedingJoinPoint, executionDuration);

        return returnValue;
    }
}
