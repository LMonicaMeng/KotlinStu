package com.kotlin.kt03

fun main(vararg args:String){
    args.flatMap {
        it.split("_")
    }.map {//类似foreach
        print("$it ")
    }
}
