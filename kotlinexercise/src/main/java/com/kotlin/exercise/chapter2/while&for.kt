package com.kotlin.exercise.chapter2

import java.util.*

//Kotlin while循环和do-while循环，语法和Java没有qubie
//while(condition){
//    /**/
//}
//
//do{
//    /**/
//}while(condition)

fun main(){
    for (i in 1 .. 100){ // [1,100]
        println(fizzBuzz(i))
    }

    println("---------------------------------")

    for(i in 100 downTo 1 step 2){
        println(fizzBuzz(i))
    }

    println("---------------------------------")

    //迭代map
    val binaryReps = TreeMap<Char,String>()

    for(c in 'A' .. 'F'){
        val binary = Integer.toBinaryString(c.toInt())
        binaryReps[c] = binary
    }

    for ((letter,binary) in binaryReps){
        println("$letter = $binary")
    }

    println("---------------------------------")

    //迭代集合
    val list = arrayListOf("10", "11", "1001")
    for ((index,element) in list.withIndex()){
        println("$index:$element")
    }

    println("---------------------------------")

    println(isLetter('q'))
    println(isLetter('x'))

    println(recognize('8'))

    println("Kotlin" in "Java" .. "Scala")

    println("Kotlin" in setOf("Java","Scala"))

}

fun fizzBuzz(i:Int) = when{
    i % 15 == 0 -> "FizzBuzz"
    i % 3 == 0 -> "Fizz"
    i % 5 == 0 -> "Buzz"
    else -> "$i"
}

//in检查值是否在区间中，!in检查值是否不在区间中
fun isLetter(c:Char) = c in 'a' .. 'z' || c in 'A' .. 'Z'
fun isNotDigit(c:Char) = c !in '0' .. '9'

fun recognize(c:Char) = when(c){
    in '0' .. '9' -> "It's a digit!"
    in 'a' .. 'z', in 'A' .. 'Z' -> "It's a letter!"
    else -> "I don't know!"
}





