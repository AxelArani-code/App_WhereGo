package com.example.wheretogo.Ui.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.wheretogo.Model.Localess
import com.example.wheretogo.R

class AdapterChips (private val itmes: List<Localess>, private val onItemClick: (Localess)->Unit):
    RecyclerView.Adapter<AdapterChips.ChipViewHolder>() {

    class ChipViewHolder (itemView:View): RecyclerView.ViewHolder(itemView){
         val textName :TextView = itemView.findViewById(R.id.text_Name_Chaip)
        fun bind (locales: Localess, onItemClick: (Localess) -> Unit){

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChipViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_chips,parent,false)
        return ChipViewHolder(view)
    }

    override fun getItemCount(): Int {
        return itmes.size
    }

    override fun onBindViewHolder(holder: ChipViewHolder, position: Int) {
        val loca = itmes[position]

    }
}