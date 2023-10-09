package com.example.wheretogo.Api

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ServiceGenerator {
    private val url = "http://192.168.1.7/api_go/"
    //https://progresfilms.000webhostapp.com/WhereGoApp/
    public val imageUrl ="http://192.168.1.4/bm/Page/img/"
    private val  client  = OkHttpClient.Builder().build()

    private val retrofit = Retrofit.Builder()
        .baseUrl(url)
        .addConverterFactory(GsonConverterFactory.create())
        .client(client)
        .build()

    fun <T> buildService(service: Class<T>): T{
        return retrofit.create(service)
    }
}