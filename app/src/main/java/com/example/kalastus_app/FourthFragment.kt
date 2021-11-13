package com.example.kalastus_app


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

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
        return view

    }




}



