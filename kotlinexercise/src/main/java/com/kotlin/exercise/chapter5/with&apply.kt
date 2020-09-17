package com.kotlin.exercise.chapter5

import android.content.Context
import android.widget.TextView
import java.lang.StringBuilder

//带接收者的函数
//with 、 apply
//with返回的值是执行lambda代码的结果
//apply返回接收者对象
fun main(){
    println(alphabet())
    println(alphabet1())
    println(alphabet2())
    println(alphabet3())
    println(alphabet4())
}

fun alphabet():String{
    val result = StringBuilder()
    for (letter in 'A' .. 'Z'){
        result.append(letter)
    }
    result.append("\nNow I know the alphabet!")
    return result.toString()
}

//上述调用了result实例上多个不同方法，而且每次调用都要重复result这个名称
//用with进行改造
fun alphabet1():String{
    val stringBuilder = StringBuilder()
    return with(stringBuilder){
        for (letter in 'A' .. 'Z'){
            this.append(letter) //this可省略
        }
        append("\nNow I know the alphabet!")
        this.toString()//this可省略
    }
}

//进一步重构
fun alphabet2() = with(StringBuilder()){
    for(letter in 'A' .. 'Z'){
        append(letter)
    }
    append("\nNow I know the alphabet!")
    toString()
}

//用apply改造
fun alphabet3() = StringBuilder().apply {
    for (letter in 'A' .. 'Z'){
        append(letter)
    }
    append("\nNow I know the alphabet!")
} .toString()

//apply初始化TextView
fun createViewWithCustomAttributes(context:Context)=
        TextView(context).apply {
            text = "Sample Text"
            textSize = 20.0f
            setPadding(20,0,0,0)
        }

//使用buildString
fun alphabet4() = buildString {
    for (letter in 'A' .. 'Z'){
        append(letter)
    }
    append("\nNow I know the alphabet!")
}
