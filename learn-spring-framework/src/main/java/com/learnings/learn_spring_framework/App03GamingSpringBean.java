package com.learnings.learn_spring_framework;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App03GamingSpringBean {

    public static void main(String[] args) {

//        var marioGame = new MarioGame();
//        var supeContraGame = new SuperContraGame();
//        GamingConsole pacmanGame = new Pacman();  //1. Object creation
//        var gameRunner = new GameRunner(pacmanGame); // 1. object creation + 2. Wiring dependencies
//        gameRunner.run();

        try(var context = new AnnotationConfigApplicationContext(GamingConfiguration.class)) {

//            var gameRunner1 = context.getBean(GameRunner.class);
//            gameRunner1.run();

//            var gameRunner2 = (GameRunner) context.getBean("gameRunner2");
//            gameRunner2.run();

            var gameRunner3 = (GameRunner) context.getBean("gameRunner3");
            gameRunner3.run();


        }


    }
}
