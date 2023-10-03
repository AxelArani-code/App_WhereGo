package com.example.wheretogo.Model_1


import com.google.gson.annotations.SerializedName
import android.support.annotation.Keep

@Keep
data class TodoPlatos(
    @SerializedName("Bocatas")
    val bocatas: List<Bocata>,
    @SerializedName("El Entrada")
    val elEntrada: List<ElEntrada>,
    @SerializedName("Ensaladas")
    val ensaladas: List<Ensalada>,
    @SerializedName("Hamburguesas")
    val hamburguesas: List<Hamburguesa>,
    @SerializedName("Omelettes")
    val omelettes: List<Omelette>,
    @SerializedName("Pastas")
    val pastas: List<Pasta>,
    @SerializedName("Pizzas")
    val pizzas: List<Pizza>,
    @SerializedName("Postres")
    val postres: List<Postre>,
    @SerializedName("Principales")
    val principales: List<Principale>,
    @SerializedName("Woks")
    val woks: List<Wok>
)