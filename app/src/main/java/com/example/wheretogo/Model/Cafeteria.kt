package com.example.wheretogo.Model


import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName


@Keep
data class Cafeteria(
    @SerializedName("Café")
    val café: List<Café>,
    @SerializedName("Promos")
    val promos: List<Promo>,
    @SerializedName("Té en hebras")
    val téEnHebras: List<TéEnHebra>
)