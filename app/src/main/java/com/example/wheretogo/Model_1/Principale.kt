package com.example.wheretogo.Model_1


import com.google.gson.annotations.SerializedName
import android.support.annotation.Keep

@Keep
data class Principale(
    @SerializedName("descripcion")
    val descripcion: String, // Costeleta de Novillo con huevos fritos y papas fritas
    @SerializedName("nombre")
    val nombre: String, // Milanesa Comun
    @SerializedName("precio")
    val precio: String // $3,920.00
)