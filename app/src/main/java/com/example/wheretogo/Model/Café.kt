package com.example.wheretogo.Model


import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName


@Keep
data class Café(
    @SerializedName("nombre")
    val nombre: String, // Cafe Chico
    @SerializedName("precio")
    val precio: Double // 430.00
)