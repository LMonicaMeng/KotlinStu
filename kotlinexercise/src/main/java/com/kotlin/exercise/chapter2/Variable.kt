package com.kotlin.exercise.chapter2

fun main(){
    //val 不可变引用，对应Java中的final
    //var 可变引用，对应非final
    val question = "The Ultimate Question of Life"
    val answer1:Int = 12 //加类型声明
    val answer = 12 //可以省略类型声明

    val yearsToCompute = 7.5e6 // 7.5 * 10^6 = 7500000.0

    val message : String
    if(canPerformOperation()){
        message = "Success"
    }
    else{
        message = "Fail"
    }

    //val引用自身是不可变的，单是它指向的对象可能是可变的
    val languages = arrayListOf("Java")
    languages.add("Kotlin")

    var answers = 12
//    answer = "no answer" //错误，类型不匹配

}

fun canPerformOperation():Boolean{return true}