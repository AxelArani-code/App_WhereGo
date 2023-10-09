package com.example.wheretogo.Model


import com.google.gson.annotations.SerializedName
import androidx.annotation.Keep

@Keep
data class Brusquetta(
    @SerializedName("descripcion")
    val descripcion: String, // Queso crema, colchón de rúcula, jamón crudo, tomates secos hidratados, aceite de oliva y hebras con parmesano.
    @SerializedName("nombre")
    val nombre: String, // Brusqueta Lennon
    @SerializedName("precio")
    val precio: String // $2,030.00
)