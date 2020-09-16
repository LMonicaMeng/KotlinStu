package com.kotlin.exercise.chapter4

import android.content.Context
import android.util.AttributeSet

fun main(){
    val alice = User3("Alice")
    println(alice.isSubscribed)

    val bob = User3("Bob",false)
    println(bob.isSubscribed)

    val carol = User3("Carol",isSubscribed = false)
    println(carol.isSubscribed)

    println(PrivateUser("123@163.com").nickname)
    println(SubscribingUser("test@kotlinlang.org").nickname)

    val user = User7("Alice")
    user.address = "Elsenheimerstrasse 47,80687 Muenchen"

    val lengthCounter = LengthCounter()
    lengthCounter.addWord("Hi!")
    println(lengthCounter.counter)
}

//带一个参数的主构造方法
class User constructor(_nickname:String){
      val nickname:String

      //初始化语句块
      init {
          nickname = _nickname
      }
}

//简化1
class User1(_nickname: String){
    val nikename = _nickname
}

//简化2 "val"意味相应的属性会用构造方法的参数来初始化
class User2(val nikename:String)

//可以为构造方法参数声明一个默认值
class User3(val nikename: String,val isSubscribed:Boolean = true)

//如果类有父类主构造方法需要初始化父类
open class User4(val nikename: String)
class TwitterUser(nickname:String):User4(nickname){}

//无参构造
open class Button3
class RadioButton:Button3()

//多个构造方法

//该类无主构造方法只有两个从构造方法
open class View1{
    constructor(ctx: Context){

    }
    constructor(ctx: Context,attr:AttributeSet){

    }
}

class MyButton:View1{
    constructor(ctx: Context):super(ctx){

    }
//可以委托给这个类的另一个构造方法
//    constructor(ctx: Context):this(ctx,MY_STYLE){
//
//    }
    constructor(ctx: Context,attr:AttributeSet):super(ctx, attr){

    }
}

interface User5{
    val nickname:String
}

// 主构造方法属性
class PrivateUser(override val nickname: String):User5
//自定义getter
class SubscribingUser(val email:String):User5{
    override val nickname: String
        get() = email.substringBefore("@")
}

//初始化属性
class FacebookUser(val accountId:Int):User5{
    override val nickname= accountId.toString()

}

interface User6{
    //抽象属性 必须重写
    val email:String
    //可以被继承
    val nickname:String
    get() = email.substringBefore("@")
}

class User7(val name:String){
    var address:String = "unspecified"
    set(value:String){
        println("""
            Address was changed for $name:
            "$field" -> "$value"
        """.trimIndent())
        field = value
    }
}

class LengthCounter{
    var counter:Int = 0
    private set

    fun addWord(word:String){
        counter += word.length
    }
}

