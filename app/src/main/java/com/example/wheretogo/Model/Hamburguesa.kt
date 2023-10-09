package com.example.wheretogo.Model


import com.google.gson.annotations.SerializedName
import androidx.annotation.Keep

@Keep
data class Hamburguesa(
    @SerializedName("descripcion")
    val descripcion: String, // Veggie, doble medallón de hamburguesa vegetariana, mozzarella, cebolla caramelizada, rúcula, tomates secos, chips de calabaza
    @SerializedName("nombre")
    val nombre: String, // Hamburguesa Bohemian
    @SerializedName("precio")
    val precio: String // $3,280.00
)