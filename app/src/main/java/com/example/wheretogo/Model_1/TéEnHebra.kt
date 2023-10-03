package com.example.wheretogo.Model_1


import com.google.gson.annotations.SerializedName
import android.support.annotation.Keep

@Keep
data class TéEnHebra(
    @SerializedName("nombre")
    val nombre: String, // Ixtén
    @SerializedName("precio")
    val precio: Double // 600.00
)