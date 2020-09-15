package com.kotlin.exercise.chapter2

import java.lang.Exception
import java.lang.IllegalArgumentException

fun main() {
    println(Color1.BLUE.rgb())
    println(getMnemonic(Color.RED))
    println(getWarmth(Color.ORANGE))
    println(mix(Color.RED, Color.YELLOW))
    println(mixOptimized(Color.BLUE, Color.YELLOW))
    println(eval(Sum(Sum(Num(1), Num(2)), Num(4))))
    println(eval(Sum(Num(1), Num(2))))
    println(evalWithLogging(Sum(Sum(Num(1), Num(2)), Num(4))))
}

enum class Color {
    RED,
    ORANGE,
    YELLOW,
    GREEN,
    BLUE,
    INDIGO,
    VIOLET
}

//声明带属性的枚举类

enum class Color1(val r: Int, val g: Int, val b: Int) {
    RED(255, 0, 0), ORANGE(255, 165, 0),
    YELLOW(255, 255, 0), GREEN(0, 255, 0),
    BLUE(0, 0, 255), INDIGO(75, 0, 130),
    VIOLET(238, 130, 238);

    //给枚举类定义一个方法
    fun rgb() = (r * 256 + g) * 256 + b
}

//when为有返回值的表达式
fun getMnemonic(color: Color) =
        when (color) {
            Color.RED -> "Richard"
            Color.ORANGE -> "Of"
            Color.YELLOW -> "York"
            Color.GREEN -> "Gave"
            Color.BLUE -> "Battle"
            Color.INDIGO -> "In"
            Color.VIOLET -> "Vain"
        }

//多个值合并到同一个分支
fun getWarmth(color: Color) = when (color) {
    Color.RED, Color.ORANGE, Color.YELLOW -> "warm"
    Color.GREEN -> "neutral"
    Color.BLUE, Color.INDIGO, Color.VIOLET -> "cold"
}

//Kotlin中when可以使用任意对象
fun mix(c1: Color, c2: Color) =
        when (setOf(c1, c2)) {
            setOf(Color.RED, Color.YELLOW) -> Color.ORANGE
            setOf(Color.YELLOW, Color.BLUE) -> Color.GREEN
            setOf(Color.BLUE, Color.VIOLET) -> Color.INDIGO
            else -> throw Exception("Dirty color")
        }

//不带参数的when,如果没有给when表达式提供参数，分支条件就是任意的布尔表达式。
fun mixOptimized(c1: Color, c2: Color) =
        when {
            (c1 == Color.RED && c2 == Color.YELLOW) || (c1 == Color.YELLOW && c2 == Color.RED) -> Color.ORANGE
            (c1 == Color.YELLOW && c2 == Color.BLUE) || (c1 == Color.BLUE && c2 == Color.YELLOW) -> Color.GREEN
            (c1 == Color.BLUE && c2 == Color.VIOLET) || (c1 == Color.VIOLET && c2 == Color.BLUE) -> Color.INDIGO
            else -> throw Exception("Dirty color")
        }


interface Expr
class Num(val value: Int) : Expr
class Sum(val left: Expr, val right: Expr) : Expr

//is检查是否是某种类型类似Java instanceOf
fun eval(e: Expr): Int {
    if (e is Num) {
        val n = e as Num
        return n.value
    }

    if (e is Sum) {
        return eval(e.right) + eval(e.left)
    }
    throw IllegalArgumentException("Unknown expression")
}

//简化1
fun eval1(e: Expr):Int =
    if(e is Num){
        e.value
    }else if(e is Sum){
        eval1(e.left) + eval(e.right)
    }else{
        throw IllegalArgumentException("Unknown expression")
    }

//简化2
fun eval2(e: Expr):Int =
        when(e){
            is Num -> e.value
            is Sum -> eval2(e.right) + eval(e.left)
            else -> throw IllegalArgumentException("Unknown expression")
        }

fun evalWithLogging(e: Expr):Int =
        when(e){
            is Num -> {
                println("num:${e.value}")
                e.value
            }
            is Sum -> {
                val left = evalWithLogging(e.left)
                val right = evalWithLogging(e.right)
                println("sum:$left + $right")
                left + right
            }
            else -> throw IllegalArgumentException("Unknown expression")
        }


