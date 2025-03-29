package com.example.aop.demo_aop.aspects;

import org.aspectj.lang.annotation.Pointcut;

public class CommonPointcutConfig {

    @Pointcut("execution(* com.example.aop.demo_aop.*.*.*(..))")
    public void commonConfig() {
        // do nothing
    }

    @Pointcut("bean(*Service*)")
    public void commonConfigUsingBeans() {}

    @Pointcut("@annotation(com.example.aop.demo_aop.annotations.TrackTime)")
    public void commonConfigUsingAnnotation() {}
}
