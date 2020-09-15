package com.kotlin.exercise.chapter3

import java.lang.IllegalArgumentException

//局部函数和扩展
fun main(){
//    saveUser(User(1,"",""))
//    saveUser1(User(1,"",""))
    //TODO 改用扩展函数的形式有问题
    saveUser2(User(1,"",""))
}

class User(val id:Int,val name:String,val address:String)

fun saveUser(user: User){
    if(user.name.isEmpty()){
        throw IllegalArgumentException(
                "Can't save user ${user.id}:empty Name"
        )
    }

    if(user.address.isEmpty()){
        throw IllegalArgumentException(
                "Can't save user ${user.id}:empty Address"
        )
    }
    //保存user到数据库。。。
}

//提取局部函数防止代码重复
fun saveUser1(user: User){
    fun validate(value:String,fieldName:String){
        if(value.isEmpty()){
            throw IllegalArgumentException("Can't save user ${user.id}:empty $fieldName")
        }
    }
    validate(user.name,"Name")
    validate(user.address,"Address")
    //保存user到数据库。。。
}

//可以把验证逻辑放在User类的扩展函数中
fun saveUser2(user: User){
    user.validateBeforeSave()

    //保存user到数据库。。。
}

fun User.validateBeforeSave(){
    fun validate(value:String,fieldName:String){
        if(value.isEmpty()){
            throw IllegalArgumentException(
                    "Can't save user $id:empty $fieldName"
            )
        }
        validate(name,"Name")
        validate(address,"Address")
    }
}