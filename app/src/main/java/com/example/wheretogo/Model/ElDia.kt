package com.example.wheretogo.Model


import com.google.gson.annotations.SerializedName
import androidx.annotation.Keep

@Keep
data class ElDia(
    @SerializedName("nombre")
    val nombre: String, // Medialuna
    @SerializedName("precio")
    val precio: String // $330.00
)