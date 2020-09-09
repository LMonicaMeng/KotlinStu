package com.btime.kt03.instance.java;

public class LazyThreadSafeSynchronized {
    private static LazyThreadSafeSynchronized INSTANCE;

    private LazyThreadSafeSynchronized(){}

    public static synchronized LazyThreadSafeSynchronized getInstance(){
        if(INSTANCE == null){
            INSTANCE = new LazyThreadSafeSynchronized();
        }
        return INSTANCE;
    }
}
