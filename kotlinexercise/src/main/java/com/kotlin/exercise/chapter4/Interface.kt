package com.kotlin.exercise.chapter4

fun main(){
    val button = Button()
    button.click()
    button.setFocus(true)
    button.showOff()
}

interface Clickable{
    fun click()
    fun showOff() = println("I'm clickable!")//kotlin中接口可以带默认实现方法
}

//:代替Java中的extends implement关键字
class Button:Clickable,Focusable{
    override fun click()= println("I was clicked")

    //如果同样的继承成员有不止一个实现，必须提供一个显示实现
    //使用尖括号加上父类型名字的"super"表明了你想要调用哪一个父类的方法
//    override fun showOff() {
//        super<Clickable>.showOff()
//        super<Focusable>.showOff()
//    }

    override fun showOff() = super<Clickable>.showOff()
}

interface Focusable{
    fun setFocus(b:Boolean) = println("I ${if(b) "got" else "lost"} focus.")
    fun showOff() = println("I'm focusable!")
}