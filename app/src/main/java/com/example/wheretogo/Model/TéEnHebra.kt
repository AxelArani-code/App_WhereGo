package com.example.wheretogo.Model


import com.google.gson.annotations.SerializedName

import androidx.annotation.Keep

@Keep
data class TéEnHebra(
    @SerializedName("nombre")
    val nombre: String, // Ixtén
    @SerializedName("precio")
    val precio: Double // 600.00
)