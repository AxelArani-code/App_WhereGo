package com.example.wheretogo.Model


import com.google.gson.annotations.SerializedName
import androidx.annotation.Keep

@Keep
data class Promo(
    @SerializedName("nombre")
    val nombre: String, // Express Cafe Y Tostadas
    @SerializedName("precio")
    val precio: Double // 800.00
)