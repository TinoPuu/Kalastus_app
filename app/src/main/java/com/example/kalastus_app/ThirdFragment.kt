package com.example.kalastus_app


import android.content.Context
import android.os.Bundle
import android.util.Log.d
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import org.w3c.dom.Element
import org.w3c.dom.Text
import java.util.*
import kotlin.random.Random

class ThirdFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val db = Firebase.firestore
        val view = inflater.inflate(R.layout.fragment_third, container,false)
        val tvKalavale : TextView = view.findViewById(R.id.tvKalavale)
        val tvKalavitsi : TextView = view.findViewById(R.id.tvKalavitsi)
        val btnKalavale : Button = view.findViewById(R.id.btnKalavale)
        val btnKalavitsi : Button = view.findViewById(R.id.btnKalavitsi)
        val btnTakaisin : Button = view.findViewById(R.id.buttonTakaisinKalavale)

        btnKalavitsi.setOnClickListener{
            val number = Random.nextInt(1,11)
            d("jpk",number.toString())
            db.collection("Kalavitsit").document(number.toString())
                .get()

                .addOnSuccessListener { result ->
                    val vitsi = result.data.toString()
                    tvKalavitsi.text = vitsi.removePrefix("{Vitsi=").removeSuffix("}")

                }
                .addOnFailureListener { exception ->
                    tvKalavitsi.text = "error"

                }
        }


        btnTakaisin.setOnClickListener {
            val fragment = FourthFragment()
            val transaction = fragmentManager?.beginTransaction()
            transaction?.replace(R.id.flFragment,fragment)?.commit()
        }
        return view
    }



}




