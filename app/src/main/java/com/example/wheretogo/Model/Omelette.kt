package com.example.wheretogo.Model


import com.google.gson.annotations.SerializedName
import androidx.annotation.Keep

@Keep
data class Omelette(
    @SerializedName("descripcion")
    val descripcion: String, // Jamon y queso.
    @SerializedName("nombre")
    val nombre: String, // Omelette Dartford
    @SerializedName("precio")
    val precio: String // $1,740.00
)