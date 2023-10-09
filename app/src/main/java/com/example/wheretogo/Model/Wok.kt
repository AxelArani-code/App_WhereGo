package com.example.wheretogo.Model


import com.google.gson.annotations.SerializedName
import androidx.annotation.Keep

@Keep
data class Wok(
    @SerializedName("descripcion")
    val descripcion: String, // Zucchini, pimiento rojo, verde, zanahoria, cebolla blanca, arroz yamaní y calabaza.
    @SerializedName("nombre")
    val nombre: String, // Wok Bahru
    @SerializedName("precio")
    val precio: String // $2,780.00
)