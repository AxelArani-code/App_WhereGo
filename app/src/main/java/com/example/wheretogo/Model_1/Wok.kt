package com.example.wheretogo.Model_1


import com.google.gson.annotations.SerializedName
import android.support.annotation.Keep

@Keep
data class Wok(
    @SerializedName("descripcion")
    val descripcion: String, // Zucchini, pimiento rojo, verde, zanahoria, cebolla blanca, arroz yamaní y calabaza.
    @SerializedName("nombre")
    val nombre: String, // Wok Bahru
    @SerializedName("precio")
    val precio: String // $2,780.00
)