package com.kotlin.exercise.chapter2

fun main(args: Array<String>) {
    println("Hello,World!")
    println(max(1, 2))
    println(max1(1, 2))
}

//if为有返回值的表达式
fun max(a:Int,b:Int):Int{
    return if(a>b) a else b
}

//简化
fun max1(a:Int,b:Int):Int= if(a>b) a else b

//再次简化
fun max2(a:Int,b:Int) = if(a>b) a else b