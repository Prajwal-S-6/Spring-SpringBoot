package com.learnings.learn_spring.helloworld;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;


record Person(String name, int age) {}

@Component
class Address {
    private String firstLine;

    public void setFirstLine(String val) {
        this.firstLine = val;
    }

    public void getFirstLine() {
        System.out.println(this.firstLine);
    }
    // public Address() {}
}
// record Address(String firstLine, String city) {}

@Component
public class HelloWorldConfiguration {

    @Autowired
    private Address address;

    public void output() {
        System.out.println(this.address);
        this.address.setFirstLine("bengaluru");
        this.address.getFirstLine();
        Person person = new Person("a", 1);


    }

//    public HelloWorldConfiguration(Address address) {
//        System.out.println(address);
//    }
//    @Bean(name = "myName")
//    public String name() {
//        return "Prajwal";
//    }


//    @Bean(name = "lastName")
//    public String lastName() {
//        return "S";
//    }

//    @Bean
//    public int age() {
//        return 25;
//    }
//
//    @Bean
//    @Primary
//    public Person person() {
//        return new Person("ravi", 20, new Address("abc", "def"));
//    }
//
//    @Bean(name = "person2")
//    public Person person2() {
//        return new Person(name(), age(), address());   //using beans in another bean using  bean method call
//        // return new Person()
//    }
//
//    @Bean(name = "person3")
//    public Person person3(String myName, int age, Address address) {  //myName, age, address
//        return new Person(myName, age, address);   //using beans in another bean using Bean name as parameter to your Bean method
//    }
//
//    @Bean(name = "person4")
//    public Person person4(String myName, int age, @Qualifier("addressQualifier") Address address) {  //myName, age, address
//        return new Person(myName, age, address);   //using beans in another bean using Bean name as parameter to your Bean method
//        // return new Person()
//    }
//
//    @Bean
//    @Qualifier("addressQualifier")
//    public Address address() {
//        return new Address("banashankari", "bangalore");
//    }
//
//    @Bean
//    @Primary
//    public Address address2() {
//        return new Address("banashankari2", "bangalore2");
//    }




}
