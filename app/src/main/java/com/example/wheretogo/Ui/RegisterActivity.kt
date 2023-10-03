package com.example.wheretogo.Ui

import android.app.Dialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.TextView
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.isVisible
import com.airbnb.lottie.LottieAnimationView
import com.example.wheretogo.R
import com.example.wheretogo.databinding.ActivityRegisterBinding
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

class RegisterActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRegisterBinding
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        auth = FirebaseAuth.getInstance()

        binding.btnBackRegister.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
        }
        binding.btnCradoUsuario.setOnClickListener {

            val email = binding.inputEmial.text.toString()
            val password = binding.inputContraseA.text.toString()
            val confirmarPaswor = binding.inputConfirmarContraseA.text.toString()

            if (email.isEmpty() || password.isEmpty() || confirmarPaswor.isEmpty()){
                Snackbar.make(binding.inputEmial,"Por favor, completa todo los campos", Snackbar.LENGTH_LONG).show()
            }else if(password != confirmarPaswor){
                Snackbar.make(binding.inputConfirmarContraseA,"Las contraseña no coninciden", Snackbar.LENGTH_LONG).show()
            }else{
                createAccount(email,password)
            }
        }

    }
    private fun createAccount(email: String, password: String) {
        auth.createUserWithEmailAndPassword(email,password)
            .addOnCompleteListener(this){task->
                if (task.isSuccessful){
                    val user = auth.currentUser
                    timeCheck(user)
                    //popupCheking()
                  //  Toast.makeText(this, "Registro exitoso: ${user?.email}", Toast.LENGTH_SHORT).show()
                }else{
                    Toast.makeText(this, "Error en el registro: ${task.exception?.message}", Toast.LENGTH_SHORT).show()
                }
            }

    }

    private fun timeCheck(user: FirebaseUser?) {
        popupCheking()
        // Start the main activity after a delay
        Handler().postDelayed({

            startActivity(Intent(this, MainActivity::class.java))
            Snackbar.make(binding.btnCradoUsuario,"Registro exitoso: ${user?.email}",Snackbar.LENGTH_LONG).show()
            finish()
        }, 2000)

    }


    private fun popupCheking (){
        val dialog = Dialog(this)
        dialog.setContentView(R.layout.popup_check)
        // Busca las vistas en el diseño personalizado
// Busca la vista de LottieAnimationView en el diseño personalizado
        val lottieView = dialog.findViewById<LottieAnimationView>(R.id.animationView_2)

// Configura la animación de Lottie
        lottieView.setAnimation(R.raw.cheching) // Reemplaza con tu archivo Lottie
        lottieView.playAnimation()


        // Asigna las animaciones de entrada y salida al diálogo
        dialog.window?.attributes?.windowAnimations = R.style.DialogAnimation

        // Cierra el diálogo cuando se toca en cualquier parte fuera de él
        dialog.window?.setBackgroundDrawableResource(android.R.color.transparent)
        dialog.setCancelable(true)

        // Muestra el diálogo
        dialog.show()
    }
}