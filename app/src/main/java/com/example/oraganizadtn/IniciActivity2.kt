package com.example.oraganizadtn

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.navigation.NavigationView
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.drawerlayout.widget.DrawerLayout
import androidx.appcompat.app.AppCompatActivity
import com.example.oraganizadtn.databinding.ActivityInici2Binding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class IniciActivity2 : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityInici2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityInici2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.appBarInici2.toolbar)
//METODO PARA MANDAAR UN MENSAJE AL DARLE CLIK AL BOTOM DE MENSAJE
        binding.appBarInici2.fab.setOnClickListener { view ->
            Snackbar.make(view, "Dejame un mensaje aqui", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
        auth = Firebase.auth

        val drawerLayout: DrawerLayout = binding.drawerLayout
        val navView: NavigationView = binding.navView
        val navController = findNavController(R.id.nav_host_fragment_content_inici2)


        // Pasar cada ID de menú como un conjunto de ID porque cada
        // el menú debe considerarse como destinos de nivel superior.
        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow
            ), drawerLayout

        )
        setupActionBarWithNavController(navController, appBarConfiguration)

        navView.setupWithNavController(navController)
    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
// Inflar el menú; esto agrega elementos a la barra de acción si está presente.

        menuInflater.inflate(R.menu.inici_activity2, menu)

        val d = findViewById<TextView>(R.id.nombre)
        d.setText("driner")


        return true

    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val f = findViewById<TextView>(R.id.horasel)

        when(item.itemId){

            R.id.action_settings->{
                auth.signOut()
                val cerrar = Intent(this,MainActivity::class.java)
                startActivity(cerrar)
            }

        }
        return super.onOptionsItemSelected(item)
    }


    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_inici2)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()

    }
}