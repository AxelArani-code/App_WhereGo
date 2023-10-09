package com.example.wheretogo.Model


import com.google.gson.annotations.SerializedName
import androidx.annotation.Keep

@Keep
data class Pizza(
    @SerializedName("descripcion")
    val descripcion: String, // Tomates secos y aceite de oliva.
    @SerializedName("nombre")
    val nombre: String, // Pizza James
    @SerializedName("precio")
    val precio: String // $3,340.00
)