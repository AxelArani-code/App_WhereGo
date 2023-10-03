package com.example.wheretogo.Ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.wheretogo.R
import com.example.wheretogo.databinding.ActivityViewLocalesBinding

private lateinit var binding: ActivityViewLocalesBinding
class ViewLocalesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityViewLocalesBinding.inflate(layoutInflater)
        val view= binding.root
        setContentView(view)

        val nombreLoca = intent.getStringExtra("localNombre")
        val ubicaicon = intent.getStringExtra("ubicacion")
        val portada = intent.getStringExtra("portada")
        val logo = intent.getStringExtra("logo")
        val phone = intent.getStringExtra("telefono")
        val time = intent.getStringExtra("time")

        binding.textNombreLocal.text = nombreLoca
        binding.textUbicacionLocal.text = ubicaicon
        binding.textFullTime.text = time
        binding.textPhone.text = phone
        Glide.with(binding.imageViewPortada).load(portada).into(binding.imageViewPortada)
        Glide.with(binding.imgLogoView).load(logo).into(binding.imgLogoView)


        binding.btnBackView.setOnClickListener {
            onBackPressed()
        }
        binding.btnMenuView.setOnClickListener {
            val intnet = Intent(this@ViewLocalesActivity,ViewMenuActivity::class.java)
            intnet.putExtra("logo", logo)
            intnet.putExtra("localNombre",nombreLoca)
            startActivity(intnet)
        }

    }

}