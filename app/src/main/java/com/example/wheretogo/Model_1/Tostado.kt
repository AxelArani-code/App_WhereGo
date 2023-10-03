package com.example.wheretogo.Model_1


import com.google.gson.annotations.SerializedName
import android.support.annotation.Keep

@Keep
data class Tostado(
    @SerializedName("descripcion")
    val descripcion: String, // Jamón, queso, ciboulette y aceite de oliva.
    @SerializedName("nombre")
    val nombre: String, // Tostado Freddie
    @SerializedName("precio")
    val precio: String // $1,860.00
)