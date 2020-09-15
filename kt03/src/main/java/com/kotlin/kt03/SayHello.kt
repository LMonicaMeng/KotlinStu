package com.kotlin.kt03

enum class Lang(private val hello:String){
    ENGLISH("Hello"),
    CHINESE("你好"),
    JAPANESE("こんにちは"),
    KOREAN("안녕하세요");

    fun sayHello(){
        println(hello)
    }

    companion object{
        fun parse(name:String):Lang{
            return Lang.valueOf(name.toUpperCase())
        }
    }
}

fun main(args:Array<String>){
    if(args.isEmpty()) return;
    val lang = Lang.parse(args[0])
    println(lang)
    lang.sayHello()
    lang.sayBye()
}

//扩展方法 加类名即可
fun Lang.sayBye(){
    val bye = when(this){
        Lang.ENGLISH -> "bye"
        Lang.CHINESE -> "再见"
        Lang.JAPANESE -> "さようなら"
        Lang.KOREAN -> "안녕히 가세요"
    }
    println(bye)
}