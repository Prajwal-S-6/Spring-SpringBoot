package com.learnings.learn_spring_framework;

import com.learnings.learn_spring_framework.game.GamingConsole;
import org.springframework.context.annotation.*;


@Configuration

// commenting because the @Component MarioGame is inside this package in another package
// if it was in different package outside of this then we need multiple @ComponentScan
//@ComponentScan("com.learnings.learn_spring_framework.game")
@ComponentScan("com.learnings.learn_spring_framework")
public class App03GamingSpringBean {

    public static void main(String[] args) {

        try(var context = new AnnotationConfigApplicationContext(App03GamingSpringBean.class)) {


            var gameRunner = (GameRunner) context.getBean(GameRunner.class);
            gameRunner.run();


        }


    }
}
