package com.example.wheretogo.Ui

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts

import com.example.wheretogo.R
import com.example.wheretogo.databinding.ActivityLoginBinding
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.tasks.Task
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    private lateinit var auth: FirebaseAuth
    private lateinit var googleSignInClient: GoogleSignInClient

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.btnCrearCuenta.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }


        auth = FirebaseAuth.getInstance()
        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(getString(R.string.deful_web_client_id))
            .requestEmail()
            .build()

        googleSignInClient = GoogleSignIn.getClient(this,gso)


        binding.btnSignInGoogle.setOnClickListener {
            signInGoogle()
        }
        binding.btnIngresar.setOnClickListener {
            val email = binding.inputEmail.text.toString()
            val password = binding.inputConstraseA.text.toString()
            if (email.isEmpty() && password.isEmpty()){
                Snackbar.make(binding.btnIngresar,"Porfavor, completa todos los campos",Snackbar.LENGTH_LONG).show()
            }else{
                signInWithEmailAndPassword(email, password)

            }
        }
    }

    private fun signInWithEmailAndPassword(email: String, password: String) {
        auth.signInWithEmailAndPassword(email,password)
            .addOnCompleteListener(this){task->
                if (task.isSuccessful){
                    startActivity(Intent(this,MainActivity::class.java))
                    finish()
                }else{
                    Snackbar.make(binding.btnIngresar,"Error alñ iniciar sesion ${task.exception?.message}", Snackbar.LENGTH_LONG).show()
                }
            }
    }



    private fun signInGoogle() {
        val signInItent = googleSignInClient.signInIntent
        launcher.launch(signInItent)
    }
    private val launcher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
        result->
        if (result.resultCode == Activity.RESULT_OK){
            val task = GoogleSignIn.getSignedInAccountFromIntent(result.data)
            handleResults(task)
        }
    }

    private fun handleResults(task : Task<GoogleSignInAccount>) {
        if (task.isSuccessful){
            val account : GoogleSignInAccount ? = task.result

            if (account != null){
                updateUI(account)
            }
        }else{
            Toast.makeText(this,task.exception.toString(),Toast.LENGTH_LONG).show()
        }
    }

    private fun updateUI(account: GoogleSignInAccount) {
        val credential = GoogleAuthProvider.getCredential(account.idToken,null)
        auth.signInWithCredential(credential).addOnCompleteListener{

            if (it.isSuccessful){
                val intent : Intent = Intent(this, MainActivity::class.java)
                val foto = account.photoUrl?.toString()
                intent.putExtra("name",account.displayName)
                intent.putExtra("email",account.email)
                intent.putExtra("photoUrl",foto)
                startActivity(intent)

            }else{
                Toast.makeText(this,it.exception.toString(),Toast.LENGTH_LONG).show()
            }
        }
    }
}