package com.kotlin.exercise.chapter2

fun main(args:Array<String>){
    val name = if(args.size >0) args[0] else "Kotlin"
    println("Hello,$name")

    //变式1
    if(args.size>0){
        println("Hello,${args[0]}")
    }

    //变式2
    println("Hello,${if(args.size>0) args[0] else "someone"}!")
}