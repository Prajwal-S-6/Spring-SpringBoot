package com.learnings.spring.fundamentals;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class SingletonBean {

    //private PrototypeBean prototypeBean;

    //public SingletonBean(PrototypeBean prototypeBean) {
    public SingletonBean() {
        //this.prototypeBean = prototypeBean;
        System.out.println("This is Singleton Bean");
    }
//
//    @Lookup
//    public PrototypeBean getPrototypeBean() {
//        return this.prototypeBean;
//    }
//
//    public void doSomething() {
//        System.out.println(getPrototypeBean());
//        System.out.println(getPrototypeBean());
//    }
}
