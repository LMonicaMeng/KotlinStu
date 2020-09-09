package com.example.myapplication

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import java.util.concurrent.atomic.AtomicLong

/**
 * Author:  mengxin
 * Date:    2019/4/30
 * Description：
 */
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initEvent()
    }

    private fun initEvent() {
        btn_lambda.setOnClickListener{
            startActivity(Intent(this,KotlinLambdaActivity::class.java))
        }

        //启动一个协程并等待1s打印Hello
        GlobalScope.launch {
            delay(1000)
            println("Hello")
        }

        Thread.sleep(2000)//等待2s
        println("Stop")

        runBlocking {
            delay(2000)
        }

        val c = AtomicLong()
        for (i in 1..1_000_000L){

        }

    }



}
