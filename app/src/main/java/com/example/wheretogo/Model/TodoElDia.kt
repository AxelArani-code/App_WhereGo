package com.example.wheretogo.Model


import com.google.gson.annotations.SerializedName
import androidx.annotation.Keep

@Keep
data class TodoElDia(
    @SerializedName("Brunchs")
    val brunchs: List<Brunch>,
    @SerializedName("Brusquettas")
    val brusquettas: List<Brusquetta>,
    @SerializedName("El Dia")
    val elDia: List<ElDia>,
    @SerializedName("Tostados")
    val tostados: List<Tostado>
)