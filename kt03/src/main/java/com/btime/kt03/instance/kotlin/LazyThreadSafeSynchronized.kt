package com.btime.kt03.instance.kotlin

class LazyThreadSafeSynchronized private constructor(){
    companion object{
        private var instance:LazyThreadSafeSynchronized ?= null

        @Synchronized
        fun get():LazyThreadSafeSynchronized{
            if(instance == null) instance = LazyThreadSafeSynchronized()
            return instance!!
        }
    }
}