package com.atguigu.team.service;

public class Status {
    private final String NAME;//final修饰的类要大写
    private Status(String name){
        this.NAME = name;

    }
    public static final Status FREE = new Status("FREE");
    public static final Status BUSY = new Status("BUSY");
    public static final Status VOCATION = new Status("VOCATION");

    public String getNAME() {
        return NAME;
    }

    @Override
    public String toString() {
        return  NAME ;
    }
}
