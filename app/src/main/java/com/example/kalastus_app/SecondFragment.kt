package com.example.kalastus_app

import android.app.DatePickerDialog
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kalastus_app.models.Kalantiedot
import com.example.kalastus_app.models.KalantiedotAdapter
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Query
import com.google.firebase.firestore.auth.FirebaseAuthCredentialsProvider
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.fragment_second.*

import java.util.*
import kotlin.random.Random


class SecondFragment : Fragment(), DatePickerDialog.OnDateSetListener{

    private lateinit var db : FirebaseFirestore
    private lateinit var ennatykset: MutableList<Kalantiedot>
    private lateinit var adapter : KalantiedotAdapter
    var day= 0
    var month = 0
    var year = 0
    var kala = ""
    var kalastustapa = ""
    var pvm = ""
    var savedDay= 0
    var savedMonth = 0
    var savedYear = 0

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {





        /*val kalaQuery = kalatiedotReference.whereEqualTo("Kala" ,btnKalavalinta.text)
        val aikaQuery = kalatiedotReference.whereEqualTo("Aika", tvDate.text)
        val kalastustapaQuery = kalatiedotReference.whereEqualTo("Tapa", btnKalastustapa.text)
*/
        val view = inflater.inflate(R.layout.fragment_second, container,false)
        val tvDate : TextView = view.findViewById(R.id.tvDate)


        tvDate.setOnClickListener {

            //"Päivämäärä" tekstiä klikkaamalla aukeaa kalenteri
            getDateTimeCalendar()
            DatePickerDialog(requireContext(), this, year, month, day).show()

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
                    R.id.action_siika ->
                        btnValitseKala.text = "Siika"
                    R.id.action_sayne ->
                        btnValitseKala.text = "Sayne"
                    R.id.action_kiiski ->
                        btnValitseKala.text = "Kiiski"
                    R.id.action_lahna ->
                        btnValitseKala.text = "Lahna"
                    R.id.action_made ->
                        btnValitseKala.text = "Made"
                    R.id.action_muikku ->
                        btnValitseKala.text = "Muikku"
                    R.id.action_silakka ->
                        btnValitseKala.text = "Silakka"
                    R.id.action_särki ->
                        btnValitseKala.text = "Särki"
                    R.id.action_taimen ->
                        btnValitseKala.text = "Taimen"

                }
                kala = "${btnValitseKala.text}"
                Log.d("zef", "$kala")
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
                    R.id.action_verkko ->
                        btnKalastustapa.text = "Verkko"
                    R.id.action_pilkki ->
                        btnKalastustapa.text = "Pilkki"
                }
                kalastustapa = "${btnKalastustapa.text}"
                Log.d("zef", "$kalastustapa")
                true
            })
            popupMenu.show()
        }

        val btnHae : Button = view.findViewById(R.id.btnHae)
        btnHae.setOnClickListener {
            db = FirebaseFirestore.getInstance()


            val kalatiedotReference = db.collection("Kalantiedot")
                .whereEqualTo("Aika", "$pvm")
                .whereEqualTo("Kala", "$kala")
                .whereEqualTo("Tapa", "$kalastustapa")

            kalatiedotReference.addSnapshotListener { snapshot, exception ->
                if (exception != null || snapshot == null) {
                    Log.d("zef", "Exception when querying", exception)
                    return@addSnapshotListener
                }
                val kalaList = snapshot.toObjects(Kalantiedot::class.java)

                for (tiedot in kalaList) {
                    Log.d("zef", "${tiedot}")


                }
                ennatykset = mutableListOf()


                //Recycleview adapter
                adapter = KalantiedotAdapter(requireContext(), ennatykset)

                rvEnnatykset.adapter = adapter
                rvEnnatykset.layoutManager = LinearLayoutManager(requireContext())

                ennatykset.clear()
                ennatykset.addAll(kalaList)
                adapter.notifyDataSetChanged()

            }
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

        pvm = ("$savedDay-$savedMonth-$savedYear")
        tvDate.text = (pvm)
        Log.d("zef","@$savedDay")
        Log.d("zef","@$savedMonth")
        Log.d("zef","@$savedYear")
    }



}


