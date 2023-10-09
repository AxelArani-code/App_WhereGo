package com.example.wheretogo.Ui

import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.wheretogo.Api.ApiService
import com.example.wheretogo.Api.ServiceGenerator

import com.example.wheretogo.Model.Provedo



import com.example.wheretogo.R
import com.example.wheretogo.Ui.Adapter.AdapterLocales
import com.example.wheretogo.databinding.ActivityMainBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import de.hdodenhof.circleimageview.CircleImageView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var auth: FirebaseAuth
   // private lateinit val serviceGenerator :ServiceGenerator
    private lateinit var apiService:ApiService

    // private  val local: List<Local> ?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        auth = FirebaseAuth.getInstance()


        val name = intent.getStringExtra("name")
        val photoUrl = intent.getStringExtra("photoUrl")
        val email = intent.getStringExtra("email")
        val user:FirebaseUser? = auth.currentUser


        binding.chipLocation.setOnClickListener {
            popupLocation()
        }

        viewLoading()
        getFunDataPerson(name,photoUrl,email,user)
        //adapterLocales()



    }


    private fun viewLoading() {
        Handler(Looper.getMainLooper()).postDelayed({
            binding.viewLoaing.isVisible = false
            binding.recyclerViewLocales.isVisible = true
            //adapterLocalesFisicos()
            adapterProvedore()
        },2000)
    }

    private fun adapterProvedore() {
        val serviceGenerator  = ServiceGenerator.buildService(ApiService::class.java)

        val call = serviceGenerator.obtenerDatosProvedores()
        call.enqueue(object :Callback<Provedo>{
            override fun onResponse(call: Call<Provedo>, response: Response<Provedo>) {
                if (response.isSuccessful) {
                    val localesResponse = response.body()
                    localesResponse?.let { response ->
                        val localesResponse = response.localesses
                        Log.v("Json",   "JsonLocaless=" + localesResponse)
                        val layouManager = LinearLayoutManager(this@MainActivity)
                        binding.recyclerViewLocales.layoutManager = layouManager
                        val adapter = AdapterLocales(localesResponse) { localess ->
                            // Tu código para manejar los locales aquí
                            val productos= localess.productos
                            // val cafe = productos.toString()
                            //   Log.v("Json",   "Json=" + cafe)

                            val intent = Intent(this@MainActivity, ViewLocalesActivity::class.java)
                            intent.putExtra("id",localess.id)
                            intent.putExtra("localNombre",localess.nombre)
                            intent.putExtra("ubicacion",localess.direccion)
                            intent.putExtra("portada",localess.portada)
                            intent.putExtra("logo",localess.logo)
                            intent.putExtra("telefono",localess.telefono)
                            intent.putExtra("time", localess.horario)
                            intent.putExtra("GPS",localess.gps)

                            //intent.putExtra("locales", local.size)
                            startActivity(intent)
                        }
                        binding.recyclerViewLocales.adapter = adapter
                    }
                } else {

                    Toast.makeText(
                        applicationContext,
                        "Error en la respuesta del servidor",
                        Toast.LENGTH_LONG
                    ).show()
                }
            }

            override fun onFailure(call: Call<Provedo>, t: Throwable) {
                binding.cardErrorConnection.visibility  = View.VISIBLE
                binding.recyclerViewLocales.visibility = View.GONE
                binding.textErrorInfo.setText("Error, ${t.message}")
                Log.v("Json", "error=" + t.message)
            }
        })
    }

    private fun getFunDataPerson(name: String?,photoUrl: String?,email: String?,user: FirebaseUser?) {
        //validaciones
        if (user != null){
            val email = user.email
            binding.textEmial.text = email
        }else{
            binding.textEmial.text = "Usuario"
        }

        if (photoUrl != null) {
            Glide.with(binding.profileImage).load(photoUrl).into(binding.profileImage)
            binding.textEmial.text = name
        }
        binding.profileImage.setOnClickListener {
            mostrarDialogoEmergente(name,photoUrl,email)
        }
    }
/*
    private fun adapterLocalesFisicos() {

        val serviceGenerator  = ServiceGenerator.buildService(ApiService::class.java)
       //val call = serviceGenerator.obtenerDatosLocalesFisicos()
      //  val call: Call<MutableList<Localess>> = serviceGenerator.obtenerDatosLocalesFisicos()


       // val call : Call<MutableList<Localess>> = apiService.obtenerDatosLocalesFisicos()
        val call = serviceGenerator.obtenerDatosLocalesFisicos()
        Log.v("Json", "errorEs=" + call)
      call.enqueue(object :Callback<MutableList<Localess>>{
          override fun onResponse(
              call: Call<MutableList<Localess>>,
              response: Response<MutableList<Localess>>
          ) {
              if (response.isSuccessful){
                  val local = response.body()

                  local?.let {
                      val layouManager = LinearLayoutManager(this@MainActivity)
                      binding.recyclerViewLocales.layoutManager = layouManager
                      val adapter = AdapterLocales(local){locales ->
                          val productos= locales.productos
                          //val cafe = productos?.cafeteria?.café
                         // Toast.makeText(applicationContext, "Josn.."+cafe, Toast.LENGTH_LONG).show()
                          val intent = Intent(this@MainActivity, ViewLocalesActivity::class.java)
                          intent.putExtra("localNombre",locales.nombre)
                          intent.putExtra("ubicacion",locales.direccion)
                          intent.putExtra("portada",locales.portada)
                          intent.putExtra("logo",locales.logo)
                          intent.putExtra("telefono",locales.telefono)
                          intent.putExtra("time", locales.horario)
                          intent.putExtra("instagram",locales.instagram)
                          //intent.putExtra("locales", local.size)
                          startActivity(intent)
                      }
                      binding.recyclerViewLocales.adapter = adapter
                  }
              }else {
                  Toast.makeText(applicationContext, "Error en la respuesta del servidor", Toast.LENGTH_LONG).show()
              }
          }

          override fun onFailure(call: Call<MutableList<Localess>>, t: Throwable) {
              Toast.makeText(applicationContext, "Error en la solicitud: ${t.message}", Toast.LENGTH_LONG).show()
              Log.v("Json", "error=" + t.message);
          }

      })
    }*/
/*
    private fun adapterLocales() {

        val retrofit = Retrofit.Builder()
            .baseUrl("http://192.168.1.7/api_go/") // Reemplaza con la base URL de tu API
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        apiService = retrofit.create(ApiService::class.java)

      //  apiService = serviceGenerator.retrofit.create(ApiService::class.java)
        // Realiza una solicitud HTTP para obtener los datos de "locales"
        val call: retrofit2.Call<List<Locales>> = apiService.obtenerDatosLocales()
        call.enqueue(object : Callback<List<Locales>> {
            override fun onResponse(
                call: retrofit2.Call<List<Locales>>,
                response: Response<List<Locales>>
            ) {
              if (response.isSuccessful){
                  val locales = response.body()
                  Log.v("Json", "index=" + locales);
                  locales?.let {
                      val layouManager = LinearLayoutManager(this@MainActivity)
                      binding.recyclerViewLocales.layoutManager = layouManager
                      //val adapter = AdapterLocales(this@MainActivity,it)
                      //binding.recyclerViewLocales.adapter = adapter
                  }
              }else{
                  Toast.makeText(applicationContext,"Error RecycreView",Toast.LENGTH_LONG).show()
              }
            }

            override fun onFailure(call: retrofit2.Call<List<Locales>>, t: Throwable) {
                Toast.makeText(applicationContext,"Error: {$call}",Toast.LENGTH_LONG).show()
            }

        })
    }*/



    private fun popupLocation() {
        val dialog = Dialog(this)
        dialog.setContentView(R.layout.popup_location)
        val textLocation = dialog.findViewById<TextView>(R.id.textViewLocation)
        val textInfo = dialog.findViewById<TextView>(R.id.textViewLocationInfo)

        dialog.window?.attributes?.windowAnimations = R.style.DialogAnimation
        // Cierra el diálogo cuando se toca en cualquier parte fuera de él
        dialog.window?.setBackgroundDrawableResource(android.R.color.transparent)
        dialog.setCancelable(true)

        // Muestra el diálogo
        dialog.show()
    }

    private fun mostrarDialogoEmergente(name: String?, photoUrl: String?, email: String?) {
        val dialog = Dialog(this)
        dialog.setContentView(R.layout.popup_perfil)

        // Busca las vistas en el diseño personalizado
        val emailTextView = dialog.findViewById<TextView>(R.id.textEmail)
        val userTextView = dialog.findViewById<TextView>(R.id.textUserName)
        val photoUrlTextView = dialog.findViewById<CircleImageView>(R.id.profile_image_2)
        val btnCerrarSecion = dialog.findViewById<Button>(R.id.btn_CerrarSecion)

        // Asigna los valores de email y photoUrl a las vistas
        emailTextView.text = email
        userTextView.text = name
        Glide.with(photoUrlTextView).load(photoUrl).into(photoUrlTextView)
        btnCerrarSecion.setOnClickListener {
            auth.signOut()
            startActivity(Intent(this, LoginActivity::class.java))
        }

        // Asigna las animaciones de entrada y salida al diálogo
        dialog.window?.attributes?.windowAnimations = R.style.DialogAnimation

        // Cierra el diálogo cuando se toca en cualquier parte fuera de él
        dialog.window?.setBackgroundDrawableResource(android.R.color.transparent)
        dialog.setCancelable(true)

        // Muestra el diálogo
        dialog.show()
    }
}

