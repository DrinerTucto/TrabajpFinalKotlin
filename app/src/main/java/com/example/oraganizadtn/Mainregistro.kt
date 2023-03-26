package com.example.oraganizadtn

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class Mainregistro : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registros)
        val user = findViewById<TextView>(R.id.usuario)
        val corre=findViewById<TextView>(R.id.correo)
        val contraseña=findViewById<TextView>(R.id.contraseña)
        val repcontra=findViewById<TextView>(R.id.repcontraseña)
        val btn = findViewById<Button>(R.id.registrarse)

        btn.setOnClickListener(){
            var contra=contraseña.text.toString()
            var pass2=repcontra.text.toString()
            if (contra.equals(pass2))
            {
                CrearUsuario(corre.text.toString(),contraseña.text.toString())
                Toast.makeText(baseContext, "INICIA SESION AHORA XD ", Toast.LENGTH_SHORT).show()

                val regreso = Intent(this,loginActivity2::class.java)
                startActivity(regreso)
            }else{
                Toast.makeText(baseContext,"Los password no coinciden",Toast.LENGTH_SHORT).show()
                contraseña.requestFocus()
            }
        }
        auth= Firebase.auth
    }
    private  fun CrearUsuario(email:String,password:String){
        auth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(this){task->

            if(task.isSuccessful) {
                Toast.makeText(baseContext, "INICIA AHORA XD ", Toast.LENGTH_SHORT).show()


            }else{
                Toast.makeText(baseContext, "Algo salio mla xd", Toast.LENGTH_SHORT).show()

            }
        }

    }
    }
