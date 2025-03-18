package com.learnings.learn_spring_framework;

public class AppGamingBasicJava {

    public static void main(String[] args) {

        var marioGame = new MarioGame();
        var supeContraGame = new SuperContraGame();
        GamingConsole pacmanGame = new Pacman();  //1. Object creation
        var gameRunner = new GameRunner(pacmanGame); // 1. object creation + 2. Wiring dependencies
        gameRunner.run();
    }
}
