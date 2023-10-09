package com.example.wheretogo.Model


import com.google.gson.annotations.SerializedName
import androidx.annotation.Keep

@Keep
data class Cafeteria(
    @SerializedName("Café")
    val café: List<Café>,
    @SerializedName("Promos")
    val promos: List<Promo>,
    @SerializedName("Té en hebras")
    val téEnHebras: List<TéEnHebra>
)