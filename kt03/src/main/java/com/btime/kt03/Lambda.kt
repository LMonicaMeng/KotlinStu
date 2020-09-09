package com.btime.kt03

import io.reactivex.Observable
import java.io.File
import java.util.concurrent.Executors

fun main(args: Array<String>) {
    val text = File(ClassLoader.getSystemResource("input").path).readText()
    Observable.fromIterable(text.toCharArray().asIterable()).filter { !it.isWhitespace() }.groupBy { it }.map {
//         it.count().subscribe(::println)
    }.subscribe()

    val worker = Executors.newCachedThreadPool()
    worker.execute {
        println("Hello")
    }
}