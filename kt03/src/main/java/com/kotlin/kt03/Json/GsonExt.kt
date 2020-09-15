package com.kotlin.kt03.Json

import com.google.gson.Gson

inline fun <reified T:Any> Gson.fromJson(json:String):T{
    return fromJson(json,T::class.java)
}