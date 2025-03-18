package com.learnings.learn_spring_framework;

import java.io.Serializable;

class POJO {
    private String text;
    private int number;

    public String toString() {
        return this.text + " " + this.number;
    }
}

//3. should implement serializable
class JavaBean implements Serializable {
    private String text;
    private int number;

    //2.must have getter and setters
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    //1. must have no-arg constructor(can be added or java will provide default)
    public JavaBean() {}

    public String toString() {
        return this.text + " " + this.number;
    }
}

public class SpringBeanVsJavaBean {

    public static void main(String[] args) {
        POJO pojo = new POJO();
        System.out.println(pojo);
    }
}
