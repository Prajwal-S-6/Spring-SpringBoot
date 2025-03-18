package com.learnings.learn_spring_framework;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

record Person(String name, int age, Address address) {}

record Address(String firstLine, String city) {}

@Configuration
public class HelloWorldConfiguration {

    @Bean(name = "myName")
    public String name() {
        return "Prajwal";
    }

//    @Bean(name = "lastName")
//    public String lastName() {
//        return "S";
//    }

    @Bean
    public int age() {
        return 25;
    }

    @Bean
    public Person person() {
        return new Person("ravi", 20, new Address("abc", "def"));
    }

    @Bean(name = "person2")
    public Person person2() {
        return new Person(name(), age(), address());   //using beans in another bean using  bean method call
        // return new Person()
    }

    @Bean(name = "person3")
    public Person person3(String myName, int age, Address address) {  //myName, age, address
        return new Person(myName, age, address);   //using beans in another bean using Bean name as parameter to your Bean method
        // return new Person()
    }

    @Bean
    public Address address() {
        return new Address("banashankari", "bangalore");
    }


}
