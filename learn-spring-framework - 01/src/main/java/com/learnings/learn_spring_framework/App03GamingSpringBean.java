package com.learnings.learn_spring_framework;

import com.learnings.learn_spring_framework.game.GamingConsole;
import com.learnings.learn_spring_framework.game.MarioGame;
import com.learnings.learn_spring_framework.game.Pacman;
import com.learnings.learn_spring_framework.game.SuperContraGame;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;


@Configuration
public class App03GamingSpringBean {

    @Bean
    @Primary
    public GamingConsole marioGame() {
        return new MarioGame();
    }

    @Bean
    @Qualifier("pacmanGame")
    public GamingConsole pacmanGame() {
        return new Pacman();
    }

    @Bean
    public GamingConsole superContraGame() {
        return new SuperContraGame();
    }

    @Bean
    @Primary
    GameRunner gameRunner1() {
        return new GameRunner(marioGame());
    }

    @Bean
    GameRunner gameRunner2(@Qualifier("pacmanGame") GamingConsole pacmanGame) {
        return new GameRunner(pacmanGame);
    }

    @Bean
    GameRunner gameRunner3() {
        return new GameRunner(superContraGame());
    }

    public static void main(String[] args) {

//        var marioGame = new MarioGame();
//        var supeContraGame = new SuperContraGame();
//        GamingConsole pacmanGame = new Pacman();  //1. Object creation
//        var gameRunner = new GameRunner(pacmanGame); // 1. object creation + 2. Wiring dependencies
//        gameRunner.run();

        try(var context = new AnnotationConfigApplicationContext(App03GamingSpringBean.class)) {

//            var gameRunner1 = context.getBean(GameRunner.class);
//            gameRunner1.run();

//            var gameRunner2 = (GameRunner) context.getBean("gameRunner2");
//            gameRunner2.run();

            var gameRunner3 = (GameRunner) context.getBean("gameRunner3");
            gameRunner3.run();


        }


    }
}
