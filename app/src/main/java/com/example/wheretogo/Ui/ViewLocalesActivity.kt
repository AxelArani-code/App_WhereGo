package com.example.wheretogo.Ui

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
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
        val id = intent.getIntExtra("id",0)
        val nombreLoca = intent.getStringExtra("localNombre")
        val ubicaicon = intent.getStringExtra("ubicacion")
        val portada = intent.getStringExtra("portada")
        val logo = intent.getStringExtra("logo")
        val phone = intent.getStringExtra("telefono")
        val time = intent.getStringExtra("time")
        val gps = intent.getStringExtra("GPS")
        val instagram = intent.getStringExtra("instagram")
        val facebook = intent.getStringExtra("facebook")

        binding.textId.text ="${id}"
        binding.textNombreLocal.text = nombreLoca
        binding.textUbicacionLocal.text = ubicaicon
        binding.textFullTime.text = time
        binding.textPhone.text = phone
        Glide.with(binding.imageViewPortada).load(portada).into(binding.imageViewPortada)
        Glide.with(binding.imgLogoView).load(logo).into(binding.imgLogoView)


        binding.btnInstagram.setOnClickListener {
            val uri = Uri.parse(instagram) // Reemplaza "instagram" con el nombre de usuario o ID de Instagram que desees abrir

            val intent = Intent(Intent.ACTION_VIEW, uri)

// Comprueba si hay una aplicación que pueda manejar el Intent
            if (intent.resolveActivity(packageManager) != null) {
                startActivity(intent)
            } else {
                // Instagram no está instalado, abre la versión web
                val webIntent = Intent(Intent.ACTION_VIEW, Uri.parse("http://instagram.com/"))
                startActivity(webIntent)
            }

        }

        binding.btnLocation.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(gps))
            if (intent.resolveActivity(packageManager)!= null){
                Toast.makeText(this, "Google Maps no está instalado", Toast.LENGTH_SHORT).show()
            }else{
                startActivity(intent)
            }
        }
        binding.btnBackView.setOnClickListener {
            onBackPressed()
        }
        binding.btnMenuView.setOnClickListener {
            val intnet = Intent(this@ViewLocalesActivity,ViewMenuActivity::class.java)
            intnet.putExtra("id",id)
            intnet.putExtra("logo", logo)
            intnet.putExtra("localNombre",nombreLoca)
            startActivity(intnet)
        }

    }



}