package com.btime.kt03.instance.kotlin

class LazyThreadSafeDoubleCheck private constructor(){
    companion object{
        private val instance by lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED){
            LazyThreadSafeDoubleCheck()
        }

        private @Volatile var instance2: LazyThreadSafeDoubleCheck ?= null

        fun get():LazyThreadSafeDoubleCheck{
            if(instance2 == null){
                synchronized(this){
                    if(instance2 == null){
                        instance2 = LazyThreadSafeDoubleCheck()
                    }
                }
            }
            return instance2!!
        }
    }
}