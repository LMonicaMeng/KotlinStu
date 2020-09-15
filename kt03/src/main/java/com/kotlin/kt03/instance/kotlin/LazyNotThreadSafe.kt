package com.kotlin.kt03.instance.kotlin

class LazyNotThreadSafe private constructor(){

    companion object{
        val instance by lazy(LazyThreadSafetyMode.NONE){//LazyThreadSafetyMode.NONE表示不是线程安全的
            LazyNotThreadSafe()
        }
    }

    //另一种写法 与Java类似
    private var instance2:LazyNotThreadSafe ?= null;

    fun get():LazyNotThreadSafe{
        if(instance2 == null){
            instance2 = LazyNotThreadSafe()
        }
        return instance2!!
    }
}