package com.learnings.spring.fundamentals;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ScopeController {

    private final BeanC beanC;
    private final BeanD beanD;

    public ScopeController(BeanC beanC, BeanD beanD) {
        this.beanC = beanC;
        this.beanD = beanD;
    }

    @GetMapping("/scope")
    public String methodA() {
        return String.format("RequestScope: %s\n Session Scope: %s\n Application Scope: %s",
                this.beanC.toString(), this.beanD.toString(),"");
    }
}
