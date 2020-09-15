package com.kotlin.restukotlin.Types.classes

import com.kotlin.restukotlin.Types.classes.kotlin.SimpleClass

fun main(){
    val simpleClass = SimpleClass(9,"Hello")
    println(simpleClass.simpleProperty)
    println(simpleClass.x)
    println(simpleClass.y)
    println(simpleClass.z)
    simpleClass.y()
    simpleClass.zzz("Sleeping ZZZ!")
}