package com.example.wheretogo.Model


import com.google.gson.annotations.SerializedName
import androidx.annotation.Keep

@Keep
data class Provedo(
    @SerializedName("localess")
    val localesses: List<Localess>
)