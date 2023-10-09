package com.example.wheretogo.Model


import com.google.gson.annotations.SerializedName
import androidx.annotation.Keep

@Keep
data class Café(
    @SerializedName("nombre")
    val nombre: String, // Cafe Chico
    @SerializedName("precio")
    val precio: Double // 430.00
)