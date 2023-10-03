package com.example.wheretogo.Ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.bumptech.glide.Glide
import com.example.wheretogo.Api.ApiService
import com.example.wheretogo.Api.ServiceGenerator
import com.example.wheretogo.Model.Cafeteria
import com.example.wheretogo.Model.Locales
import com.example.wheretogo.Model.Productos
import com.example.wheretogo.Model.Provedo
import com.example.wheretogo.R
import com.example.wheretogo.Ui.Adapter.AdapterChips
import com.example.wheretogo.databinding.ActivityViewLocalesBinding
import com.example.wheretogo.databinding.ActivityViewMenuBinding
import com.google.android.material.chip.Chip
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

private lateinit var binding: ActivityViewMenuBinding
class ViewMenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityViewMenuBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


        val logotipo = intent.getStringExtra("logo")
        val nombreLocal = intent.getStringExtra("localNombre")
        binding.textNombreProvider.text = nombreLocal
        Glide.with(binding.imageLogotipo).load(logotipo).into(binding.imageLogotipo)


        binding.btnBack.setOnClickListener {
            onBackPressed()
        }
        getProducto()
    }

    private fun getProducto() {
        val serviceGenerador = ServiceGenerator.buildService(ApiService::class.java)
        val call = serviceGenerador.obtenerDatosProductos()
        call.enqueue(object :Callback<List<Productos>>{
            override fun onResponse(
                call: Call<List<Productos>>,
                response: Response<List<Productos>>
            ) {
                if (response.isSuccessful) {
                    val productos = response.body()

                    productos?.let { listaProductos ->
                        // Crear chips para cada producto
                        for (producto in listaProductos) {
                            val chip = createChip(producto.cafeteria.toString())
                            Log.v("Json",   "JsonProductos=" + chip)
                        }
                    }
                } else {
                    // Manejar error en la respuesta del servidor
                    // Puedes mostrar un mensaje de error o realizar otras acciones aquí

            }
            }

            override fun onFailure(call: Call<List<Productos>>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })
    }

    private fun createChip(nombre: String): Chip {
        val chip = Chip(this)
        chip.text = nombre
        // Configura otras propiedades del chip según sea necesario
        return chip
    }
}