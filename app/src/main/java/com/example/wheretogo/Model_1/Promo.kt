package com.example.wheretogo.Model_1


import com.google.gson.annotations.SerializedName
import android.support.annotation.Keep

@Keep
data class Promo(
    @SerializedName("nombre")
    val nombre: String, // Express Cafe Y Tostadas
    @SerializedName("precio")
    val precio: Double // 800.00
)