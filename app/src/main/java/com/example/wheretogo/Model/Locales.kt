package com.example.wheretogo.Model


import com.google.gson.annotations.SerializedName

import androidx.annotation.Keep

@Keep
data class Locales(
    @SerializedName("id")
    val id: Int,
    @SerializedName("direccion")
    val direccion: String, // Hipólito Yrigoyen, Int. Egidio Casnati 1899, M5600 San Rafael, Mendoza
    @SerializedName("horario")
    val horario: String, // Lunes a Sabado 08:00 am - 2:30 am
    @SerializedName("logo")
    val logo: String, // https://github.com/AxelArani-code/api_WhereGo/blob/main/logo_baruh.png?raw=true
    @SerializedName("nombre")
    val nombre: String, // Bahru
    @SerializedName("portada")
    val portada: String, // https://raw.githubusercontent.com/AxelArani-code/api_WhereGo/main/portada_baruh.webp
    @SerializedName("productos")
    val productos: Productos,
    @SerializedName("telefono")
    val telefono: String, // 0260154625273
    @SerializedName("instagram")
    val instagram:String,
    @SerializedName("facebook")
    val facebook:String,
)