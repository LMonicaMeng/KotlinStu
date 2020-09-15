package com.kotlin.exercise.chapter2

//导入Java包
import java.util.*

fun main(){
    val person = Person("Bob", true)
    println(person.name)
    println(person.isMarried)

    val rectangle = Rectangle(41, 42)
    println(rectangle.isSquare)
}
class Person(val name:String,val isMarried:Boolean)

class Rectangle(val height:Int,val width:Int){
    val isSquare : Boolean
    get() {
        return height == width
    }
}

fun createRandomRectangle(): Rectangle {
    val random = Random()
    return Rectangle(random.nextInt(), random.nextInt())
}