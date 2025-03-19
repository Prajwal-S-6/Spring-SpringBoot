package com.learnings.learn_spring_framework.game;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class Pacman implements GamingConsole {
    @Override
    public void up() {
        System.out.println("Jump");
    }

    @Override
    public void down() {
        System.out.println("Jump down");
    }

    @Override
    public void left() {
        System.out.println("Go left");
    }

    @Override
    public void right() {
        System.out.println("Go right");
    }
}
