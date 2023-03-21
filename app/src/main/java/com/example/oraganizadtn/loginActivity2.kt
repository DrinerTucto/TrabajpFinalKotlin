package com.example.oraganizadtn

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.ktx.Firebase


class loginActivity2 : AppCompatActivity() {
      override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login2)
        val image = findViewById<ImageView>(R.id.image)
        val image2 = findViewById<ImageView>(R.id.image1)
        val image3 = findViewById<ImageView>(R.id.otro)

        val name = intent.extras?.getString("hombre").orEmpty()

        if (name == "hombre") {
          image2.visibility=View.VISIBLE


        }
        if (name == "mujer") {
            image.visibility=View.VISIBLE


        }
        if (name=="otro"){
            image3.visibility=View.VISIBLE

        }

    }
}