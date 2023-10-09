package com.example.wheretogo.Model


import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName


@Keep
data class Localess(
    @SerializedName("direccion")
    val direccion: String, // Hipólito Yrigoyen, Int. Egidio Casnati 1899, M5600 San Rafael, Mendoza
    @SerializedName("facebook")
    val facebook: String, // https://www.facebook.com/bahru.club/?locale=es_LA
    @SerializedName("horario")
    val horario: String, // Lunes a Sabado 08:00 am - 2:30 am
    @SerializedName("id")
    val id: Int, // 1
    @SerializedName("instagram")
    val instagram: String, // https://www.instagram.com/bahru.club/?hl=es
    @SerializedName("logo")
    val logo: String, // https://raw.githubusercontent.com/AxelArani-code/api_WhereGo/d6302c9584bf6aaee9426881de1dc1a5a16fa6df/logo_baruh.svg
    @SerializedName("nombre")
    val nombre: String, // Bahru
    @SerializedName("portada")
    val portada: String, // https://raw.githubusercontent.com/AxelArani-code/api_WhereGo/main/portada_baruh.webp
    @SerializedName("productos")
    val productos: Productos,
    @SerializedName("telefono")
    val telefono: String ,// 0260154625273
    @SerializedName("GPS")
    val gps: String // GPS

)