package com.kotlin.restukotlin.BuiltinTypes.collections

fun main(){

    val intList:List<Int> = listOf(1,2,3,4)
    val intList2:MutableList<Int> = mutableListOf(1,2,3,4)

    val map:Map<String,Any> = mapOf("name" to "benny", "age" to 20)
    val map2:Map<String,Any> = mutableMapOf("name" to "benny","age" to 20)

    val stringList = ArrayList<String>()

    for (i in 0 .. 10){ // [0,10]
        stringList.add("num: $i")
    }

    for (i in 0 .. 10){
        stringList += "num: $i"
    }

    for (i in 0 .. 10){
        stringList -= "num: $i"
    }

    stringList[5] = "HelloWorld"
    val valueAt5 = stringList[5]

    val hashMap = HashMap<String,Int>()
    hashMap["Hello"] = 10
    println(hashMap["Hello"])
}