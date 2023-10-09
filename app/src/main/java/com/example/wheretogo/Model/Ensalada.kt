package com.example.wheretogo.Model


import com.google.gson.annotations.SerializedName
import androidx.annotation.Keep

@Keep
data class Ensalada(
    @SerializedName("descripcion")
    val descripcion: String, // Palta zanahoria, alcaparras, hebras de queso, semillas, crutones y aceite de oliva.
    @SerializedName("nombre")
    val nombre: String, // Ensalada Bahru
    @SerializedName("precio")
    val precio: String // $2,780.00
)