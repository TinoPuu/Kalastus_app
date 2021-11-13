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
        val thirdFragment = ThirdFragment()
        val fourthFragment = FourthFragment()

        supportFragmentManager.beginTransaction().apply {
            replace(R.id.flFragment, fourthFragment)
            commit()

        }

        "btnFragment1.setOnClickListener{}"

        val btnKalavalikko: Button = findViewById(R.id.btnFragment1)

        btnKalavalikko.setOnClickListener {
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.flFragment, firstFragment)
                commit()
            }
        }

        val btnKalaennatys: Button = findViewById(R.id.btnFragment2)

        btnKalaennatys.setOnClickListener {
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.flFragment, secondFragment)

                commit()
            }
        }

        val btnKalavale: Button = findViewById(R.id.btnFragment3)

        btnKalavale.setOnClickListener {
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.flFragment, thirdFragment)

                commit()
            }
        }




    }
}