package com.example.wheretogo.Model_1


import com.google.gson.annotations.SerializedName
import android.support.annotation.Keep

@Keep
data class Pizza(
    @SerializedName("descripcion")
    val descripcion: String, // Tomates secos y aceite de oliva.
    @SerializedName("nombre")
    val nombre: String, // Pizza James
    @SerializedName("precio")
    val precio: String // $3,340.00
)