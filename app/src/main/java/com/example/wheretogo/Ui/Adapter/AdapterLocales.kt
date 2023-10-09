package com.example.wheretogo.Ui.Adapter



import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.wheretogo.Model.Localess

import com.example.wheretogo.R

class AdapterLocales(private val localesList: List<Localess>, private val onItemClick: (Localess)->Unit) :
    RecyclerView.Adapter<AdapterLocales.LocalViewHolder>() {

    class LocalViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        private val tiempoTextView: TextView = itemView.findViewById(R.id.text_time)
        private  val direccionTextView: TextView = itemView.findViewById(R.id.text_ubicacion)
        private val imagenPortada: ImageView = itemView.findViewById(R.id.img_portada_1)
        private val imagenLogo: ImageView = itemView.findViewById(R.id.img_logo)

        fun bind(locales: Localess, onItemClick: (Localess)->Unit ){
            tiempoTextView.text = locales.horario
            direccionTextView.text = locales.direccion
            Glide.with(imagenPortada.context).load(locales.portada).into(imagenPortada)
            Glide.with(imagenLogo.context).load(locales.logo).into(imagenLogo)

            itemView.setOnClickListener {
                onItemClick(locales)
            }
        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LocalViewHolder {
       val view = LayoutInflater.from(parent.context).inflate(R.layout.view_card_local,parent,false)
        return LocalViewHolder(view)
    }

    override fun getItemCount(): Int {
       return localesList.size
    }

    @SuppressLint("SuspiciousIndentation")
    override fun onBindViewHolder(holder: LocalViewHolder, position: Int) {
      val local = localesList[position]
        holder.bind(local,onItemClick)
      //  holder.tiempoTextView.text = local.horario
      //  holder.direccionTextView.text = local.direccion
      //  Glide.with(holder.imagenPortada).load(local.portada).into(holder.imagenPortada)
       // Glide.with(holder.imagenLogo).load(local.logo).into(holder.imagenLogo)
    }
}