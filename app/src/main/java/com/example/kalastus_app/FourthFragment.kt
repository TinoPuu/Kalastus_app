package com.example.kalastus_app


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.view.isVisible
import com.google.android.material.button.MaterialButtonToggleGroup
import kotlinx.android.synthetic.main.fragment_fourth.*

class FourthFragment : Fragment(R.layout.fragment_fourth) {


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {



        val view = inflater.inflate(R.layout.fragment_fourth, container, false)

        val buttonKala1 : Button = view.findViewById(R.id.buttonKalavalikko)

        val buttonKala2 : Button = view.findViewById(R.id.buttonKalaennatys)

        val buttonKala3 : Button = view.findViewById(R.id.buttonKalavale)

        val buttonDark : Button = view.findViewById(R.id.btn_Dark)

        val buttonLight : Button = view.findViewById(R.id.btn_Light)


        buttonKala1.setOnClickListener {
            val fragment = FirstFragment()
            val siirtyminen = fragmentManager?.beginTransaction()
            siirtyminen?.replace(R.id.flFragment,fragment)?.commit()
        }

        buttonKala2.setOnClickListener {
            val fragment = SecondFragment()
            val siirtyminen = fragmentManager?.beginTransaction()
            siirtyminen?.replace(R.id.flFragment,fragment)?.commit()
        }

        buttonKala3.setOnClickListener {
            val fragment = ThirdFragment()
            val siirtyminen = fragmentManager?.beginTransaction()
            siirtyminen?.replace(R.id.flFragment,fragment)?.commit()
        }

        buttonDark.setOnClickListener {
            val theme = AppCompatDelegate.MODE_NIGHT_YES
            AppCompatDelegate.setDefaultNightMode(theme)
        }

        buttonLight.setOnClickListener {
            val theme = AppCompatDelegate.MODE_NIGHT_NO
            AppCompatDelegate.setDefaultNightMode(theme)
        }

        return view

    }




}



