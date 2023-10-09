package com.example.wheretogo.Model


import com.google.gson.annotations.SerializedName
import androidx.annotation.Keep

@Keep
data class Postre(
    @SerializedName("descripcion")
    val descripcion: String, // Helado de coco y vainilla, corazón de salsa de limón dulce, bañado en chocolate blanco, decorado con una galleta de limón y cascara de limón glaseado
    @SerializedName("nombre")
    val nombre: String, // Tiramisu
    @SerializedName("precio")
    val precio: String // $1,350.00
)