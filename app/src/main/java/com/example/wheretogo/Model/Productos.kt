package com.example.wheretogo.Model


import com.google.gson.annotations.SerializedName
import androidx.annotation.Keep

@Keep
data class Productos(
    @SerializedName("cafeteria")
    val cafeteria: Cafeteria,
    @SerializedName("Todo El Dia")
    val todoElDia: TodoElDia?,
    @SerializedName("Todo Platos")
    val todoPlatos: TodoPlatos?
)