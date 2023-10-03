package com.example.wheretogo.Model_1


import com.google.gson.annotations.SerializedName
import android.support.annotation.Keep

@Keep
data class ElDia(
    @SerializedName("nombre")
    val nombre: String, // Medialuna
    @SerializedName("precio")
    val precio: String // $330.00
)