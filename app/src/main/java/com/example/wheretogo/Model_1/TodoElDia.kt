package com.example.wheretogo.Model_1


import com.google.gson.annotations.SerializedName
import android.support.annotation.Keep

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