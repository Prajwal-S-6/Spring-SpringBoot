package com.learnings.learn_spring_framework.game;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class GameRunner {

    // always wires supercontrgame
    @Autowired
    @Qualifier("SuperContraGameQualifier")
    private GamingConsole game;

    // wires bean of type GamingConsole if only one @Component;
    // else class with @Component & @Primary
//    @Autowired
//    private GamingConsole game;


    // OR wiring using constructor
//    public GameRunner(@Qualifier("SuperContraGameQualifier") GamingConsole game) {
//        this.game = game;
//    }


    public void run() {
        System.out.println("running game " + game);
        this.game.up();
        this.game.right();
        this.game.down();
        this.game.left();
    }
}
