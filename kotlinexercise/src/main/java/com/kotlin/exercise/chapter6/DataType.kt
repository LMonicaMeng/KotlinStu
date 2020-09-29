package com.kotlin.exercise.chapter6



//整数类型：Byte、Short、Int、Long
//浮点数类型：Float、Double
//字符类型：Char
//布尔类型：Boolean
//类型转换：toByte()、toShort()、toChar()   Int.toLong()/Long.toInt()
val i = 1
val l:Long = i.toLong()

//Any Unit Nothing
fun fail(message:String):Nothing{
    throw IllegalStateException(message)
}

fun main(){
    fail("Error occurred")

}

