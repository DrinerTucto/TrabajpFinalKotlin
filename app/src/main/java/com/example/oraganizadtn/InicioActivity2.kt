package com.example.oraganizadtn
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class InicioActivity2 : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    private lateinit var btn:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inicio2)
        auth = Firebase.auth

        btn=findViewById(R.id.cerrarSesion)
        btn.setOnClickListener {
            auth.signOut()
            val cerrar = Intent(this,MainActivity::class.java)

            startActivity(cerrar)

        }


    }
}