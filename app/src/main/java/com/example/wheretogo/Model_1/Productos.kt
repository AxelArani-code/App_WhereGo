package com.example.wheretogo.Model_1


import com.google.gson.annotations.SerializedName
import android.support.annotation.Keep

@Keep
data class Productos(
    @SerializedName("cafeteria")
    val cafeteria: Cafeteria,
    @SerializedName("Todo El Dia")
    val todoElDia: TodoElDia,
    @SerializedName("Todo Platos")
    val todoPlatos: TodoPlatos
)