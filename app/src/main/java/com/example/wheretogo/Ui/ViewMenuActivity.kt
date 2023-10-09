package com.example.wheretogo.Ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.bumptech.glide.Glide
import com.example.wheretogo.Api.ApiService
import com.example.wheretogo.Api.ServiceGenerator
import com.example.wheretogo.Model.Café
import com.example.wheretogo.Model.Productos
import com.example.wheretogo.Model.Promo
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

        val id = intent.getIntExtra("id",0)
        val logotipo = intent.getStringExtra("logo")
        val nombreLocal = intent.getStringExtra("localNombre")
        binding.textNombreProvider.text = nombreLocal
        Glide.with(binding.imageLogotipo).load(logotipo).into(binding.imageLogotipo)


        if (id == 1){
            getProducto()
        }

        binding.btnBack.setOnClickListener {
            onBackPressed()
        }

    }

    private fun getProducto() {
        val serviceGenerador = ServiceGenerator.buildService(ApiService::class.java)
        val call = serviceGenerador.obtenerDatosProductos()
        call.enqueue(object :Callback<Productos>{
            override fun onResponse(call: Call<Productos>, response: Response<Productos>) {
                if (response.isSuccessful){
                    val productos= response.body()
                    Log.v("Json",   "JsonLocal=" + productos)

                    productos?.let {productos: Productos ->
                        //val chip = Chip(this@ViewMenuActivity)
                       // chip.text = "${productos}"
                       // binding.chipGroup.addView(chip)
                       mostrarProductosEnChips(productos)
                    }
                }
            }

            override fun onFailure(call: Call<Productos>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })
    }


    private fun mostrarProductosEnChips(prodcutos: Productos) {
        fun agregarChips(nombre:String){
            val chip = Chip(this)
            chip.text = nombre
            binding.chipGroup.addView(chip)
        }
        prodcutos.cafeteria.apply {
            agregarChips(nombre = "cafeteria")

        }
        prodcutos.todoElDia.apply {
            agregarChips(nombre = "Todo El Dia")
        }
        prodcutos.todoPlatos.apply {
            agregarChips(nombre = "Todo Platos")
        }
    }
}