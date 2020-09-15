package com.kotlin.exercise.chapter3

//顶层函数和属性
fun <T> joinToString3(collection:Collection<T>,separator:String=", ",prefix:String = "",postfix:String = ""):String{
    val result = StringBuilder(prefix)
    for ((index,element) in collection.withIndex()){
        if(index>0) result.append(separator)
        result.append(element)
    }
    result.append(postfix)
    return result.toString()
}

var opCount = 0

fun performOperation(){
    opCount++
}

//顶层函数定义常量
val UNIX_LINE_SEPARATOR = "\n" //只有getter
var UNIX_LINE_SEPARATOR_A = "\n" //既有getter又有setter

//相当于Java中的public static final String UNIX_LINE_SEPARATOR_ = "\n"
const val UNIX_LINE_SEPARATOR_ = "\n"

