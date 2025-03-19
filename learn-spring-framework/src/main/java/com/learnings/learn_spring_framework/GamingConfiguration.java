package com.learnings.learn_spring_framework;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class GamingConfiguration {

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


}
