package com.btime.restukotlin.Types.classes.kotlin

open class SimpleClass(var x: Int, val y: String) : AbsClass(), SimpleInf {
    override fun absMethod() {}

    override val simpleProperty: Int
        get() {
            return 2
        }
    val z: Long
        get() {
            return simpleProperty * 2L
        }

    override fun simpleMethod() {}

    fun y() {}

    fun zzz(string: String) {}

    final override fun overridable(){}

}

class SimpleClass2(x:Int,y: String):SimpleClass(x,y){

}