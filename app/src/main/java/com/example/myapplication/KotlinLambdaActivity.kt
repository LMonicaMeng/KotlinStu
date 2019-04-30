package com.example.myapplication

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_kotlin_lambda.*

/**
 * Author:  mengxin
 * Date:    2019/4/30
 * Description：Lambda表达式的本质实际上是匿名函数，因为底层实现是匿名函数，但现在不关注底层实现。
 * 利用Lambda表达式使代码更加简洁，这是我们的关注点。
 * Lambda表达式的一些特征：
 * 1>Lambda表达式经常被大括号括着。2>其参数（如果存在）在->前。3>函数体（如果存在）在->后面
 */
class KotlinLambdaActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kotlin_lambda)
        initEvent()
    }

    private fun initEvent() {
        //Lambda表达式的语法
        //1、无参数
        noParameter()
        //2、有参数
        haveParameter()
        //3、Lambda表达式作为函数中的一部分
        lambdaAsParameter()
        //4、it并不是Kotlin中的关键字，高阶函数Lambda表达式只有一个参数，用it代替
        aboutIt()
    }
    //Kotlin中的it
    private fun aboutIt() {
     //it不是关键字，可用于变量名称
        val it:Int = 0

    }

    //Lambda表达式作为函数中的参数
    private fun lambdaAsParameter() {
        //源代码
        fun test(a: Int, b: Int): Int {
            return a + b
        }

        fun sum(m: Int, n: Int): Int {
            return m + n
        }
        //调用
        test(10, sum(3, 5))

        //Lambda表达式写法(高阶函数，只提供参数，调用时需要具体实现)
        //invoke（）函数：通过函数变量调用自身
        fun test(a: Int, b: (num1: Int, num2: Int) -> Int): Int {
            return a + b.invoke(3, 5)
        }

        //调用
        test(10,{num1, num2 -> num1+num2 })
    }

    //有参数，举两个参数的例子
    private fun haveParameter() {
        //源代码
        fun test(a: Int, b: Int): Int {
            return a + b
        }
        //Lambda表达式写法一
//        val test:(Int,Int)->Int = {a,b -> a+b}
        //Lambda表达式写法二
        val test = { a: Int, b: Int -> a + b }
        //调用
        test(3, 5)
    }

    //无参数
    private fun noParameter() {
        // 源代码
        fun test() {
            println("无参数")
        }
        //Lambda表达式
        val test = println("无参数")
        //调用
        test()
    }
}