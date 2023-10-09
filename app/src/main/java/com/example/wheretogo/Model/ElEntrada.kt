package com.example.wheretogo.Model


import com.google.gson.annotations.SerializedName
import androidx.annotation.Keep

@Keep
data class ElEntrada(
    @SerializedName("descripcion")
    val descripcion: String, // Alitas de pollo estilo kentuchy acompañado con salsa picante y papas fritas
    @SerializedName("nombre")
    val nombre: String, // Papas Fritas
    @SerializedName("precio")
    val precio: String // $1,980.00
)