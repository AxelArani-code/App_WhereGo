package com.example.wheretogo.Model


import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName


@Keep
data class Productos(
    @SerializedName("cafeteria")
    val cafeteria: Cafeteria
)