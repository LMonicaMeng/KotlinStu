package com.kotlin.exercise.chapter2

import java.io.BufferedReader
import java.io.StringReader
import java.lang.NumberFormatException

fun main(){
   val reader = BufferedReader(StringReader("239"))
    println(readNumber(reader))
    val reader1 = BufferedReader(StringReader("not a number"))
    readNumber1(reader1)
}

fun readNumber(reader:BufferedReader):Int?{
    try {
        val line = reader.readLine()
        return Integer.parseInt(line)
    }catch (e : NumberFormatException){
        return null
    }
    finally {
        reader.close()
    }
}

fun readNumber1(reader: BufferedReader){
    val number = try {
        Integer.parseInt(reader.readLine())
    }catch (e:NumberFormatException){
        //return
        null
    }
    println(number)
}