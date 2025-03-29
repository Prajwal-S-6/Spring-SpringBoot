package com.example.aop.demo_aop.aspects;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Configuration
@Aspect
public class LoggingAspect {

   private Logger LOG = LoggerFactory.getLogger(getClass());

   @Before("com.example.aop.demo_aop.aspects.CommonPointcutConfig.commonConfigUsingBeans()")
   public void logMethodCallBefore(JoinPoint joinPoint) {
       LOG.info("Before Aspect- {} is called with argument: {}", joinPoint, joinPoint.getArgs());
   }

    @After("com.example.aop.demo_aop.aspects.CommonPointcutConfig.commonConfig()")
//    @AfterThrowing("execution(* com.example.aop.demo_aop.*.*.*(..))", throwing="execution)
//    @AfterReturning(value = "execution(* com.example.aop.demo_aop.*.*.*(..))", returning = "returnvalue")
    public void logMethodCallAfter(JoinPoint joinPoint) {
        LOG.info("After Aspect- {} has executed", joinPoint);
    }
}
