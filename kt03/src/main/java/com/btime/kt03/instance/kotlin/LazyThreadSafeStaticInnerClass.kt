package com.btime.kt03.instance.kotlin

class LazyThreadSafeStaticInnerClass private constructor(){
    companion object{
        fun getInstance() = Holder.instance
    }

    private object Holder{
        val instance = LazyThreadSafeStaticInnerClass()
    }
}