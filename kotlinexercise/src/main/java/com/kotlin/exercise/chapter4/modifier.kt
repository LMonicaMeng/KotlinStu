package com.kotlin.exercise.chapter4

import com.kotlin.exercise.chapter4.Clickable
import com.kotlin.exercise.chapter4.Focusable

//所有声明都默认为public 和 final的
//kotlin访问修饰符open final abstract
//可见性修饰符public；private类中可见 protected子类中可见
//特有修饰符internal，表示只在模块内部可见(与Java混编慎用)
open class RichButton : Clickable{
    //这个函数是final的，不能在子类中重写
    fun disable(){}
    //这个函数是open的，可以在子类中重写
    open fun animate(){}

    //加final禁止重写
    final override fun click() {

    }
}

abstract class Animated{
    abstract fun animate()

    //抽象类中的非抽象函数并不是默认open的，但是可以标注为open的
    open fun stopAnimating(){

    }

    fun animateTwice(){

    }
}

internal open class TalkativeButton:Focusable{
    private fun yell() = println("Hey!")
    protected fun whisper() = println("Let's talk!")
}


