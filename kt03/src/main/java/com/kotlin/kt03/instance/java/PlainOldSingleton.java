package com.kotlin.kt03.instance.java;

public class PlainOldSingleton {
    private static PlainOldSingleton instance = new PlainOldSingleton();

    private PlainOldSingleton(){};

    public static PlainOldSingleton getInstance(){
        return instance;
    }
}
