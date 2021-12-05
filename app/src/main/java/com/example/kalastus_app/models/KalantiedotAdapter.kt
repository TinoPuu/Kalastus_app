package com.example.kalastus_app.models

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.kalastus_app.R
import com.example.kalastus_app.models.Kalantiedot
import kotlinx.android.synthetic.main.item_ennatykset.view.*


class KalantiedotAdapter (val context: Context, val ennatykset : List<Kalantiedot>) :
    RecyclerView.Adapter<KalantiedotAdapter.ViewHolder>() {




    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_ennatykset, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(ennatykset[position])
    }

    override fun getItemCount() = ennatykset.size

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(kalantiedot: Kalantiedot) {

            itemView.tvAika.text = kalantiedot.Aika
            itemView.tvKala.text = kalantiedot.Kala
            itemView.tvKalastaja.text = kalantiedot.Kalastaja
            itemView.tvPaikka.text = kalantiedot.Paikka
            itemView.tvPaino.text = kalantiedot.Paino
            itemView.tvTapa.text = kalantiedot.Tapa


        }


    }
}