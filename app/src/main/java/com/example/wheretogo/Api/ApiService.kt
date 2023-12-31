package com.example.wheretogo.Api



import com.example.wheretogo.Model.Localess
import com.example.wheretogo.Model.Productos
import com.example.wheretogo.Model.Provedo



import retrofit2.Call
import retrofit2.http.GET

interface ApiService {



    @GET("mode.php")
    fun obtenerDatosLocalesFisicos(): Call<MutableList<Localess>>

    @GET("mode.php")
    fun obtenerDatosProvedores(): Call<Provedo>


    @GET("mode.php")
    fun obtenerDatosProductos(): Call<Productos>


    @GET("local-beta.php")
    fun obtenerDatosPoductos(): Call<MutableList<Localess>>
}