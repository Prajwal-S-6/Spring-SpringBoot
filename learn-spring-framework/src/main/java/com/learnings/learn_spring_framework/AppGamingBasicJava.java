package com.learnings.learn_spring_framework;

public class AppGamingBasicJava {

    public static void main(String[] args) {

        var marioGame = new MarioGame();
        var supeContraGame = new SuperContraGame();
        var gameRunner = new GameRunner(supeContraGame);
        gameRunner.run();
    }
}
