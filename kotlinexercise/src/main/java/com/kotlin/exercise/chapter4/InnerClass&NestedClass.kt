package com.kotlin.exercise.chapter4

import java.io.Serializable
import java.lang.IllegalArgumentException

//内部类和嵌套类
//嵌套类（不存储外部类的引用）
// Java：static class A
// Kotlin：class A
//内部类（村春外部类的引用）
//Java：class A
//Kotlin：inner class A
interface State:Serializable

interface View{
    fun getCurrentState():State
    fun restoreState(state: State){}
}

class Button1:View{
    override fun getCurrentState(): State =ButtonState()

    override fun restoreState(state: State) {
        /*..*/
    }
    //类似Java中静态嵌套类
    class ButtonState:State{/*..*/}
}

class Outer{
    inner class Inner{
        fun getOuterReference():Outer = this@Outer
    }
}

interface Expr
class Num(val value:Int):Expr
class Sum(val left:Expr,val right:Expr):Expr

fun eval(e:Expr):Int=
    when(e){
        is Num -> e.value
        is Sum -> eval(e.right)+ eval(e.left)
        else -> throw IllegalArgumentException("Unknown expression")
    }

sealed class Expr1{
    class Num(val value: Int):Expr1()
    class Sum(val left: Expr,val right: Expr):Expr1()
}

//密封类不需要提供默认的分支
fun eval1(e: Expr1):Int =
        when(e){
            is Expr1.Num -> e.value
            is Expr1.Sum -> eval(e.right)+ eval(e.left)
        }
