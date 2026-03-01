package com.learnings.spring.fundamentals;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class PrototypeBean {

    private SingletonBean singletonBean;

    public PrototypeBean(SingletonBean singletonBean) {
        this.singletonBean =singletonBean;
        System.out.println("This is Prototype bean");
        System.out.println(this.singletonBean);
    }
}
