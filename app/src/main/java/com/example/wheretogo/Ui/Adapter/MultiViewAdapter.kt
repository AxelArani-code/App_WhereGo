package com.example.wheretogo.Ui.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.wheretogo.Model.Cafeteria
import com.example.wheretogo.R

class MultiViewAdapter(private val productos: Map<String, List<Cafeteria>>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>()  {
    private val VIEW_TYPE_PROMO = 1
    private val VIEW_TYPE_CAFE = 2
    private val VIEW_TYPE_TE = 3
    inner class PromoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nombreTextView: TextView = itemView.findViewById(R.id.textViewNombrePromo)
        val precioTextView: TextView = itemView.findViewById(R.id.textViewPrecioPromo)
    }

    inner class CafeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nombreTextView: TextView = itemView.findViewById(R.id.textViewNombreCafe)
        val precioTextView: TextView = itemView.findViewById(R.id.textViewPrecioCafe)
    }

    inner class TeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nombreTextView: TextView = itemView.findViewById(R.id.textViewNombreTe)
        val precioTextView: TextView = itemView.findViewById(R.id.textViewPrecioTe)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            VIEW_TYPE_PROMO -> {
                val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_promo, parent, false)
                PromoViewHolder(view)
            }
            VIEW_TYPE_CAFE -> {
                val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_cafe, parent, false)
                CafeViewHolder(view)
            }
            VIEW_TYPE_TE -> {
                val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_te, parent, false)
                TeViewHolder(view)
            }
            else -> throw IllegalArgumentException("Invalid view type")
        }
    }

    override fun getItemCount(): Int {
        return productos.size
    }
    override fun getItemViewType(position: Int): Int {
        val key = productos.keys.toList()[position]
        return when (key) {
            "Promos" -> VIEW_TYPE_PROMO
            "Café" -> VIEW_TYPE_CAFE
            "Té en hebras" -> VIEW_TYPE_TE
            else -> throw IllegalArgumentException("Invalid key")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val key = productos.keys.toList()[position]
        val productosList = productos[key] ?: return

        when (holder.itemViewType) {
            VIEW_TYPE_PROMO -> {
                val promoHolder = holder as PromoViewHolder
                for (producto in productosList) {
               //     promoHolder.nombreTextView.text = producto.promos.toString()
                 //   promoHolder.precioTextView.text = producto.precio.toString()
                    // Puedes agregar más lógica si es necesario
                }
            }
            VIEW_TYPE_CAFE -> {
                val cafeHolder = holder as CafeViewHolder
                for (producto in productosList) {
                   // cafeHolder.nombreTextView.text = producto.
                   // cafeHolder.precioTextView.text = producto.precio.toString()
                    // Puedes agregar más lógica si es necesario
                }
            }
            VIEW_TYPE_TE -> {
                val teHolder = holder as TeViewHolder
                for (producto in productosList) {
                    //teHolder.nombreTextView.text = producto.nombre
                   // teHolder.precioTextView.text = producto.precio.toString()
                    // Puedes agregar más lógica si es necesario
                }
            }
        }
    }


}