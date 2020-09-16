package com.kotlin.exercise.chapter4

import android.provider.ContactsContract

//伴生对象因为kotlin无static，私有成员不能在类外部的顶层函数中使用而引入
fun main(){
    A.bar()

    val subscribingUser = User01.newSubscribingUser("bob@gmail.com")
    val facebookUser = User01.newFacebookUser(4)
    println(subscribingUser.nickname)

    //调用扩展函数类似调用伴生对象定义的方法
    val p = Person3.fromJSON(json = "")
}

class A{
    companion object{
        fun bar(){
            println("Companion object called")
        }
    }
}

fun getFacebookName(facebookAccountId: Int):String{
    return facebookAccountId.toString()
}

class User0{
    val nickname:String

    constructor(email:String){
        nickname = email.substringBefore('@')
    }

    constructor(facebookAccountId:Int){
        nickname = getFacebookName(facebookAccountId)
    }
}

class User01 private constructor(val nickname: String){
    companion object{
        fun newSubscribingUser(email: String) =
                User01(email.substringBefore('@'))

        fun newFacebookUser(accountId:Int) =
                User01(getFacebookName(accountId))
    }
}

//声明命名伴生对象
class Person1(val name:String){
    companion object Loader{
        fun fromJSON(jsonText:String):Person1 = Person1(jsonText)
    }
}

//在伴生对象中实现接口
interface JSONFactory<T>{
    fun fromJson(jsonText: String):T
}

class Person2(val name: String){
    companion object : JSONFactory<Person2>{
        override fun fromJson(jsonText: String): Person2 {
            TODO("Not yet implemented")
        }
    }
}

//为伴生对象定义一个扩展函数
class Person3(val name: String,val lastName:String){
    // 为了类定义扩展，必须声明一个伴生对象，即使为空
    companion object{

    }
}

fun Person3.Companion.fromJSON(json:String):Person3{
    TODO()
}

//对象表达式：改变写法的匿名内部类
//window.addMouseListener(
//    object:MouseAdapter(){
//        override fun mouseClicked(e:MouseEvent){
//            //...
//        }
//    }
//)

//val listerner = object : MouseAdapter(){
//    override fun mouseClicked(e:MouseEvent){}
//}
