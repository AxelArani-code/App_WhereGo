package com.example.wheretogo.Model_1


import com.google.gson.annotations.SerializedName
import android.support.annotation.Keep

@Keep
data class Admin(
    @SerializedName("locales")
    val locales: List<Locale>
)