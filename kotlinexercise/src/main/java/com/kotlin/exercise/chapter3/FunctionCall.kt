package com.kotlin.exercise.chapter3

fun main(){
    val set = hashSetOf(1,7,53)
    val list = arrayListOf(1,7,53)
    val map = hashMapOf(1 to "one",7 to "seven",53 to "fifty-three")

    println(set.javaClass)
    println(list.javaClass)
    println(map.javaClass)

    val strings = listOf("first","second","fourteenth")
    println(strings.last())

    val numbers = setOf(1,14,2)
    println(numbers.max())

    val list1 = listOf(1,2,3)
    println(list1) //触发toString()的调用

    println(joinToString(list1,"; ","(",")"))
    //更优雅的写法,可以显示的表明参数的名称
    println(joinToString(list1,separator = " ",prefix = " ",postfix = "."))

    println(joinToString1(list1,", ","",""))
    println(joinToString1(list1))
    println(joinToString1(list1,";"))
    println(joinToString1(list1,prefix = "# ",postfix = ";"))

    //访问顶层函数和属性
    println(joinToString3(list1,"*"))
    performOperation()
    reportOperationCount()

    println("Kotlin".lastChar())

    //解构声明
    val(number,name) = 1 to "one"


}


fun <T> joinToString(collection:Collection<T>,separator:String,prefix:String,postfix:String):String{
    val result = StringBuilder(prefix)
    for ((index,element) in collection.withIndex()){
        if(index>0) result.append(separator)
        result.append(element)
    }
    result.append(postfix)
    return result.toString()
}

//声明函数的时候，指定参数的默认值，可以避免创建重载的函数
//有默认值的参数
//Java无参数默认值概念，Java调Kotlin函数的时候，必须显示的指定所以参数值，如果需要在Java中频繁调用加注解@JvmOverloads
//加注解后编译器会生成重载函数
@JvmOverloads
fun <T> joinToString1(collection:Collection<T>,separator:String=", ",prefix:String = "",postfix:String = ""):String{
    val result = StringBuilder(prefix)
    for ((index,element) in collection.withIndex()){
        if(index>0) result.append(separator)
        result.append(element)
    }
    result.append(postfix)
    return result.toString()
}

//访问顶层属性
fun reportOperationCount(){
    println("Operation performed $opCount times")
}

//可变参数
//源码用到可变参数
//public fun <T> listOf(vararg elements: T): List<T> = if (elements.size > 0) elements.asList() else emptyList()
val list = listOf(1,2,3)

//允许中缀调用 用infix 修饰符
val map = mapOf(1 to "one",2 to "two") //to 称为中缀调用

