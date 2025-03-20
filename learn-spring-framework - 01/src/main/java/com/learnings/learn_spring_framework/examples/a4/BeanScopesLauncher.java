package com.learnings.learn_spring_framework.examples.a4;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.Component;

@Component
class NormalClass {
    public NormalClass() {
        System.out.println("Normal/Singleton");
    }
}

@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
class PrototypeClass {
    public PrototypeClass() {
        System.out.println("Prototype");
    }

}

@Configuration
@ComponentScan
public class BeanScopesLauncher {

    public static void main(String[] args) {

        try(var context = new AnnotationConfigApplicationContext(BeanScopesLauncher.class)) {

            context.getBean(NormalClass.class);
            context.getBean(NormalClass.class);
            context.getBean(NormalClass.class);

            context.getBean(PrototypeClass.class);
            context.getBean(PrototypeClass.class);
            context.getBean(PrototypeClass.class);
            context.getBean(PrototypeClass.class);




        }


    }
}
