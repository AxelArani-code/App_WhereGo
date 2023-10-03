package com.example.wheretogo.Model_1


import com.google.gson.annotations.SerializedName
import android.support.annotation.Keep

@Keep
data class Pasta(
    @SerializedName("descripcion")
    val descripcion: Any, // null
    @SerializedName("nombre")
    val nombre: String, // Lasagna Bahru
    @SerializedName("precio")
    val precio: String // $3,270.00
)