package com.btime.kt03.player

fun main(args:Array<String>){
    val player:Player = Player()
    player.play("")
    player.pause()
    player.resume()
    player.seekTo(200)
    player.stop()
}