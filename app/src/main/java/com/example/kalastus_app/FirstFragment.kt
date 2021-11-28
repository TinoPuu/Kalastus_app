package com.example.kalastus_app

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.PopupMenu
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_fourth.*

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

        val btnLisaakala : Button = view.findViewById(R.id.btnLisaakala)
        btnLisaakala.setOnClickListener {
            val popupMenu: PopupMenu = PopupMenu(requireContext(),btnLisaakala)
            popupMenu.menuInflater.inflate(R.menu.popup_kalat,popupMenu.menu)
            popupMenu.setOnMenuItemClickListener(PopupMenu.OnMenuItemClickListener { item ->
                when(item.itemId) {
                    R.id.action_ahven ->
                        btnLisaakala.text = "Ahven"
                    R.id.action_hauki ->
                        btnLisaakala.text = "Hauki"
                    R.id.action_kuha ->
                        btnLisaakala.text = "Kuha"
                    R.id.action_siika ->
                        btnLisaakala.text = "Siika"
                    R.id.action_sayne ->
                        btnLisaakala.text = "Sayne"
                    R.id.action_aki ->
                        btnLisaakala.text = "Aki"
                }

                true
            })
            popupMenu.show()
        }
        val btnTapa : Button = view.findViewById(R.id.btnTapa)
        btnTapa.setOnClickListener {
            val popupMenu: PopupMenu = PopupMenu(requireContext(),btnTapa)
            popupMenu.menuInflater.inflate(R.menu.popup_kalastustavat,popupMenu.menu)
            popupMenu.setOnMenuItemClickListener(PopupMenu.OnMenuItemClickListener { item ->
                when(item.itemId) {
                    R.id.action_jigi ->
                        btnTapa.text = "Jigi"
                    R.id.action_perho ->
                        btnTapa.text = "Perho"
                    R.id.action_uistin ->
                        btnTapa.text = "Uistin"
                    R.id.action_verkko ->
                        btnTapa.text = "Verkko"
                    R.id.action_pilkki ->
                        btnTapa.text = "Pilkki"

                }

                true
            })
            popupMenu.show()
        }
        val btnPaikka : Button = view.findViewById(R.id.btnPaikka)
        btnPaikka.setOnClickListener {
            val popupMenu: PopupMenu = PopupMenu(requireContext(),btnPaikka)
            popupMenu.menuInflater.inflate(R.menu.popup_kalastuspaikka,popupMenu.menu)
            popupMenu.setOnMenuItemClickListener(PopupMenu.OnMenuItemClickListener { item ->
                when(item.itemId) {
                    R.id.action_lampi ->
                        btnPaikka.text = "Lampi"
                    R.id.action_järvi ->
                        btnPaikka.text = "Järvi"
                    R.id.action_joki ->
                        btnPaikka.text = "Joki"


                }

                true
            })
            popupMenu.show()
        }
        val Paino : (EditText) = view.findViewById(R.id.Paino)

      return view
    }


}