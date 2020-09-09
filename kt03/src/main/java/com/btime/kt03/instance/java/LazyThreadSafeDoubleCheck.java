package com.btime.kt03.instance.java;

public class LazyThreadSafeDoubleCheck {
    private static volatile LazyThreadSafeDoubleCheck INSTANCE;

    private LazyThreadSafeDoubleCheck(){}

    public static LazyThreadSafeDoubleCheck getInstance(){
        if(INSTANCE == null){
            synchronized (LazyThreadSafeDoubleCheck.class){
                if(INSTANCE == null){
                    //初始化分为实例化和赋值两步，尽管我们把这一步写成下面的语句，
                    //但Java虚拟机并不保证其他线程这两步的顺序究竟是怎么样的
                    INSTANCE = new LazyThreadSafeDoubleCheck();
                }
            }
        }
        return INSTANCE;
    }
}
