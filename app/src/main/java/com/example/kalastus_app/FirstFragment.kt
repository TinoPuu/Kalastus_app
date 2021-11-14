package com.example.kalastus_app

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button

class FirstFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_first, container,false)
        val btnTakaisin : Button = view.findViewById(R.id.buttonTakaisinKalavalikko)
        btnTakaisin.setOnClickListener {
            val fragment = FourthFragment()
            val transaction = fragmentManager?.beginTransaction()
            transaction?.replace(R.id.flFragment,fragment)?.commit()
        }
        //tästä napista avautuu kalan lisäys kohta
        val btnLisaakala : Button = view.findViewById(R.id.buttonLisääkala)
        btnLisaakala.setOnClickListener {

        }

      return view
    }


}