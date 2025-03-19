package com.learnings.learn_spring_framework.game;

import org.springframework.context.annotation.*;


@Configuration

// commenting because the @Component MarioGame is inside this package in another package
// if it was in different package outside of this then we need multiple @ComponentScan
//@ComponentScan("com.learnings.learn_spring_framework.game")
@ComponentScan("com.learnings.learn_spring_framework")
public class GamingAppLauncher {

    public static void main(String[] args) {

        try(var context = new AnnotationConfigApplicationContext(GamingAppLauncher.class)) {

            var gameRunner = (GameRunner) context.getBean(GameRunner.class);
            gameRunner.run();


        }


    }
}
