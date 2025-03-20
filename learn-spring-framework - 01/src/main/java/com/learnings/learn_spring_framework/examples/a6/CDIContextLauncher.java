package com.learnings.learn_spring_framework.examples.a6;

import jakarta.inject.Inject;
import jakarta.inject.Named;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.Arrays;

// Jakarta C-DI annotations are alternative to Spring annotations
// @Component
@Named
class BusinessService {
   DataService dataService;


    public DataService getDataService() {
        System.out.println("this is getter");
        return dataService;
    }

    // @Autowired
    @Inject
    public void setDataService(DataService dataService) {
        System.out.println("this is setter");
        this.dataService = dataService;
    }
}

// @Component -- with Jakarta C-DI these annotation behaves same as spring
@Named
class DataService {

}

@Configuration
@ComponentScan
public class CDIContextLauncher {

    public static void main(String[] args) {

        try(var context = new AnnotationConfigApplicationContext(CDIContextLauncher.class)) {

            // Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);

            System.out.println(context.getBean(BusinessService.class).getDataService());

        }


    }
}
