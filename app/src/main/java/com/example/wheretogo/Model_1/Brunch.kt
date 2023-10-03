package com.example.wheretogo.Model_1


import com.google.gson.annotations.SerializedName
import android.support.annotation.Keep

@Keep
data class Brunch(
    @SerializedName("descripcion")
    val descripcion: String, // Tazón de café con leche o té, medialuna con jamón y queso, huevos revueltos con bacon más rebanadas de pan integral tostado. Jugo de naranja y bowl de frutas frescas.
    @SerializedName("nombre")
    val nombre: String, // Brunch Bowie
    @SerializedName("precio")
    val precio: String // $5,180.00
)