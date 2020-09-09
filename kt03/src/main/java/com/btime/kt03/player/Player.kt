package com.btime.kt03.player

import kotlin.properties.Delegates

class Player {
     private var state:State by Delegates.observable(State.IDLE,{prop,old,new ->
         println("$old -> $new")
         onPlayStateChangedListener?.onStateChanged(old,new)
     })

    private fun sendCmd(cmd:PlayerCmd){
        when(cmd){
            is PlayerCmd.Play -> {
                println("\n play ${cmd.url} from ${cmd.position}ms")
                state = State.PLAYING
                doPlay(cmd.url,cmd.position)
            }

            is PlayerCmd.Resume -> {
                println("\n Resume")
                state = State.PLAYING
                doResume()
            }

            is PlayerCmd.Pause -> {
                println("\n Pause")
                state = State.PAUSE
                doPause()
            }

            is PlayerCmd.Stop -> {
                println("\n Stop")
                state = State.IDLE
                doStop()
            }

            is PlayerCmd.Seek -> {
                println("\n Seek to ${cmd.position}ms,state:$state")
            }
        }
    }

    private fun doStop() {
        //todo
    }

    private fun doPause() {
        //todo
    }

    private fun doResume() {
        //todo
    }

    private fun doPlay(url: String, position: Long) {
        //todo
    }

    interface OnPlayStateChangedListener{
        fun onStateChanged(oldState:State,new:State)
    }

    private var onPlayStateChangedListener:OnPlayStateChangedListener ?= null


    fun play(url:String,position: Long = 0){
        sendCmd(PlayerCmd.Play(url,position))
    }

    fun resume(){
        sendCmd(PlayerCmd.Resume)
    }

    fun pause(){
        sendCmd(PlayerCmd.Pause)
    }

    fun stop(){
        sendCmd(PlayerCmd.Stop)
    }

    fun seekTo(position: Long){
        sendCmd(PlayerCmd.Seek(position))
    }

}