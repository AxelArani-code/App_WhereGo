package com.example.wheretogo.Model

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName
@Keep
data class Provedo(
    @SerializedName("localess")
    val localess: List<Locales>
)
