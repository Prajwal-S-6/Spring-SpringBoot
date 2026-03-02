package com.learnings.spring.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main implements CommandLineRunner {

    @Autowired
    UserService userService;

    static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        try {
//            userService.noRollbackForCheckedException();
//            userService.rollbackForCheckedException();
//            userService.rollbackForUnCheckedException();
            userService.noRollbackForUnCheckedException();
        } catch (Exception e){

        }
    }
}
