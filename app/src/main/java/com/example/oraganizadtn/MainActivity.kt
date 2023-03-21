package com.example.oraganizadtn

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.RadioButton
import androidx.core.view.isInvisible
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {
    private lateinit var auth : FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        auth= Firebase.auth

        val r1 = findViewById<RadioButton>(R.id.radioButton)
        val r2 = findViewById<RadioButton>(R.id.radioButton2)
        val r3 = findViewById<RadioButton>(R.id.radioButton3)
        val btn = findViewById<Button>(R.id.button2)



        btn.setOnClickListener {
            if (r1.isChecked) {
                validarhm("hombre")

            }
            if (r2.isChecked) {
                validarhm("mujer")
            }
            if(r3.isChecked){
                validarhm("otro")

            }
        }
    }


    fun validarhm(validar: String) {
        val intent = Intent(this, loginActivity2::class.java)
        var genero = validar
        intent.putExtra("hombre", genero)
        startActivity(intent)


    }

}