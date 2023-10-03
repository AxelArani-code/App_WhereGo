package com.example.wheretogo.Model_1


import com.google.gson.annotations.SerializedName
import android.support.annotation.Keep

@Keep
data class Cafeteria(
    @SerializedName("Café")
    val café: List<Café>,
    @SerializedName("Promos")
    val promos: List<Promo>,
    @SerializedName("Té en hebras")
    val téEnHebras: List<TéEnHebra>
)