package com.example.wheretogo.Model_1


import com.google.gson.annotations.SerializedName
import android.support.annotation.Keep

@Keep
data class Omelette(
    @SerializedName("descripcion")
    val descripcion: String, // Jamon y queso.
    @SerializedName("nombre")
    val nombre: String, // Omelette Dartford
    @SerializedName("precio")
    val precio: String // $1,740.00
)