package com.kotlin.exercise.chapter3

import android.view.View
import android.widget.Button
import java.lang.StringBuilder

//扩展函数和属性
fun main(){
    println("Kotlin".lastChar())
    val list = listOf(1,2,3)
    println(list.joinToString(separator = ";",prefix = "(",postfix = ")"))

    val list1 = arrayListOf(1,2,3)
    println(list1.joinToString(" "))

    println(listOf("one","two","eight").join(" "))

    //伪代码调用
    //扩展函数不能被重写
//    val view :Button = Button()
//    view.showOff()
//    打印结果：I'm a view!

    val sb = StringBuilder("Kotlin?")
    sb.lastChar = '!'
    println(sb)

}

//扩展函数为类的成员函数，不过定义在类的外边
//为String类添加自己的方法
fun String.lastChar():Char = this.get(this.length -1)

fun <T> Collection<T>.joinToString(separator:String = ", ",prefix:String = "",postfix:String = ""):String{
    val result = StringBuilder(prefix)

    for((index,element) in this.withIndex()){
        if(index > 0) result.append(separator)
        result.append(element)
    }
    result.append(postfix)
    return result.toString()
}

fun Collection<String>.join(separator: String = ", ",prefix: String = "",postfix: String = "")=joinToString(separator, prefix, postfix)

fun View.showOff() = println("I'm a view!")
fun Button.showOff() = println("I'm a button!")

var StringBuilder.lastChar:Char
get() = get(length - 1)
set(value:Char) {
    this.setCharAt(length-1,value)
}

