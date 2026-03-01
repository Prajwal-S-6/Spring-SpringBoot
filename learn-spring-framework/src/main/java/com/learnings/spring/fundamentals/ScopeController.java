package com.learnings.spring.fundamentals;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ScopeController {

    private final RequestScopeBean requestScopeBean;
    private final SessionScopeBean sessionScopeBean;
    private final ApplicationScopeBean applicationScopeBean;

    public ScopeController(RequestScopeBean requestScopeBean, SessionScopeBean sessionScopeBean, ApplicationScopeBean applicationScopeBean) {
        this.requestScopeBean = requestScopeBean;
        this.sessionScopeBean = sessionScopeBean;
        this.applicationScopeBean = applicationScopeBean;
    }

    @GetMapping("/scope")
    public String methodA() {
        return String.format("RequestScope: %s\n Session Scope: %s\n Application Scope: %s",
                this.requestScopeBean.toString(), this.sessionScopeBean.toString(),this.applicationScopeBean.toString());
    }
}
