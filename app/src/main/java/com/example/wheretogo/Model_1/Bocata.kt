package com.example.wheretogo.Model_1


import com.google.gson.annotations.SerializedName
import android.support.annotation.Keep

@Keep
data class Bocata(
    @SerializedName("descripcion")
    val descripcion: String, // Vacio desmenuzado, mozzarella, colchón de verdes y tomates.
    @SerializedName("nombre")
    val nombre: String, // Bocata Creedence
    @SerializedName("precio")
    val precio: String // $3,460.00
)