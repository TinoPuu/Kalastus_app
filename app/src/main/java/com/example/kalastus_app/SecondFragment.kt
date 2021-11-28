package com.example.kalastus_app

import android.app.DatePickerDialog
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*

import java.util.*


class SecondFragment : Fragment(), DatePickerDialog.OnDateSetListener{

    var day= 0
    var month = 0
    var year = 0

    var savedDay= 0
    var savedMonth = 0
    var savedYear = 0
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_second, container,false)
        val tvDate : TextView= view.findViewById(R.id.tvDate)
        tvDate.setOnClickListener {

            //"Päivämäärä" tekstiä klikkaamalla aukeaa kalenteri
            getDateTimeCalendar()
            DatePickerDialog(requireContext(), this, year, month, day).show()

            //keskeneräinen, päivittää vasta kun kalenteri avataan uudelleen, korjattava jotenkin
            tvDate.text = "$savedDay-$savedMonth-$savedYear"

        }

        val btnTakaisin : Button = view.findViewById(R.id.buttonTakaisinKalaennatys)
        btnTakaisin.setOnClickListener {
            val fragment = FourthFragment()
            val transaction = fragmentManager?.beginTransaction()
            transaction?.replace(R.id.flFragment,fragment)?.commit()
        }
        val btnValitseKala : Button = view.findViewById(R.id.btnKalavalinta)
        btnValitseKala.setOnClickListener {
            val popupMenu: PopupMenu = PopupMenu(requireContext(),btnValitseKala)
            popupMenu.menuInflater.inflate(R.menu.popup_kalat,popupMenu.menu)
            popupMenu.setOnMenuItemClickListener(PopupMenu.OnMenuItemClickListener { item ->
                when(item.itemId) {
                    //muutetaan buttonin tekstiksi menusta klikattu kala
                    R.id.action_ahven ->
                    btnValitseKala.text = "Ahven"
                    R.id.action_hauki ->
                        btnValitseKala.text = "Hauki"
                    R.id.action_kuha ->
                        btnValitseKala.text = "Kuha"

                }

                true
            })
            popupMenu.show()
        }
        val btnKalastustapa : Button = view.findViewById(R.id.btnKalastustapa)
        btnKalastustapa.setOnClickListener {
            val popupMenu: PopupMenu = PopupMenu(requireContext(),btnKalastustapa)
            popupMenu.menuInflater.inflate(R.menu.popup_kalastustavat,popupMenu.menu)
            popupMenu.setOnMenuItemClickListener(PopupMenu.OnMenuItemClickListener { item ->
                when(item.itemId) {
                    //muutetaan buttonin tekstiksi menusta klikattu kalastustapa
                    R.id.action_jigi ->
                        btnKalastustapa.text = "Jigi"
                    R.id.action_perho ->
                        btnKalastustapa.text = "Perho"
                    R.id.action_uistin ->
                        btnKalastustapa.text = "Uistin"

                }

                true
            })
            popupMenu.show()
        }

     return view
    }



    private fun getDateTimeCalendar() {
        //Haetaan kalenterista päivämäärä
        val cal = Calendar.getInstance()
        day = cal.get(Calendar.DAY_OF_MONTH)
        month = cal.get(Calendar.MONTH)
        year = cal.get(Calendar.YEAR)
    }



    override fun onDateSet(view: DatePicker?, year: Int, month: Int, day: Int) {

        // Otetaan päivämäärä kalenterista talteen
        savedDay = day
        savedMonth = month
        savedYear = year



        Log.d("zef","@$savedDay")
        Log.d("zef","@$savedMonth")
        Log.d("zef","@$savedYear")
    }



}


