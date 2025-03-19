package com.learnings.learn_spring_framework;

import com.learnings.learn_spring_framework.game.GamingConsole;

public class GameRunner {
    // private MarioGame game;
    private GamingConsole game;
    public GameRunner(GamingConsole game) {
        this.game = game;
    }

    public void run() {
        System.out.println("running game " + game);
        this.game.up();
        this.game.right();
        this.game.down();
        this.game.left();
    }
}
