package com.btime.kt03

import java.math.BigInteger

//尾递归函数
class Result(var value:BigInteger = BigInteger.valueOf(1L))

tailrec fun factorial(num:Int,result: Result){
    if(num == 0) result.value=result.value.times(BigInteger.valueOf(1L))
    else{
        result.value = result.value.times(BigInteger.valueOf(num.toLong()))
        factorial(num-1,result)
    }
}

fun main(args:Array<String>){
   val result = Result()
    factorial(1000000,result)
    println(result.value)
}