package com.example.kalastus_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        //asdasdasdasdasdasdasd
        //asdjaopisdjpioasdjaåpsodjoå
        //tässä testi :DDD
        //Tinon testi pogo pogo pogo
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val firstFragment = FirstFragment()
        val secondFragment = SecondFragment()

        supportFragmentManager.beginTransaction().apply {
            replace(R.id.flFragment, firstFragment)
            commit()
        }

        "btnFragment1.setOnClickListener{}"




    }
}