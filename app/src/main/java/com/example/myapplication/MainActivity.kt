package com.example.myapplication

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
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
    }


}
