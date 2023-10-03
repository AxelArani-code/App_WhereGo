package com.example.wheretogo.Model_1


import com.google.gson.annotations.SerializedName
import android.support.annotation.Keep

@Keep
data class Café(
    @SerializedName("nombre")
    val nombre: String, // Cafe Chico
    @SerializedName("precio")
    val precio: Double // 430.00
)