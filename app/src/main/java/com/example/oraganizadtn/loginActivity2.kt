package com.example.oraganizadtn

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase


class loginActivity2 : AppCompatActivity() {
     private lateinit var autho: FirebaseAuth.AuthStateListener
    private lateinit var auth: FirebaseAuth
    private lateinit var googleSingcliente: GoogleSignInClient
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login2)
        val image = findViewById<ImageView>(R.id.image)
        val image2 = findViewById<ImageView>(R.id.image1)
        val image3 = findViewById<ImageView>(R.id.otro)
        val bt = findViewById<Button>(R.id.button5)
        val email =findViewById<TextView>(R.id.email)
        val password =findViewById<TextView>(R.id.pass)
        val registros=findViewById<Button>(R.id.dr)

        registros.setOnClickListener {
            val inte = Intent(this,Mainregistro::class.java)
            startActivity(inte)
        }
        bt.setOnClickListener {
            if(email.text.toString()==""||password.text.toString()==""){
                Toast.makeText(this, "Los campos no pueden estar basillos", Toast.LENGTH_SHORT).show()
            }else{
                login(email.text.toString(),password.text.toString())

            }
        }


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

        auth= Firebase.auth

         val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(getString(R.string.default_web_client_id))//token generado de nuestra app
            .requestEmail()//lo que queremos solicitar al hacer login
            .build()
        googleSingcliente = GoogleSignIn.getClient(this, gso)
        findViewById<Button>(R.id.gSingInbtn).setOnClickListener {
            signIngoogle()
        }


    }
fun valida(){

}

    private fun signIngoogle() {
        val signIntent = googleSingcliente.signInIntent
        laucher.launch(signIntent)
    }

    private val laucher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == Activity.RESULT_OK) {
                val task = GoogleSignIn.getSignedInAccountFromIntent(result.data)
                hadleResults(task)
            }
        }

    private fun hadleResults(task: Task<GoogleSignInAccount>) {
        if (task.isSuccessful) {
            val account: GoogleSignInAccount? = task.result //recuperar el correo introducido
            if (account != null) {
                updateUO(account)
            }

        } else {
            Toast.makeText(this, task.exception.toString(), Toast.LENGTH_SHORT).show()
        }

    }

    private fun updateUO(account: GoogleSignInAccount) {
        val credential = GoogleAuthProvider.getCredential(account.idToken,null)
        auth.signInWithCredential(credential).addOnCompleteListener{task->

            if (task.isSuccessful){

                val intent: Intent=Intent(this,IniciActivity2::class.java)
                startActivity(intent)

            }else{
                Toast.makeText(this,task.exception.toString(), Toast.LENGTH_SHORT).show()
            }
        }
    }
//ESTO ARA QUE SE MANTENGA LA SESION DE LA PAGINA DONDE ESTAS AL CERRAR LA APLICACION
    override fun onStart() {
        super.onStart()
        if (auth.currentUser != null){
              val intent: Intent=Intent(this,IniciActivity2::class.java)
              startActivity(intent)

        }
    }

    private fun login(email:String,pasword:String) {

        auth.signInWithEmailAndPassword(email, pasword)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    val user = auth.currentUser
                    Toast.makeText(baseContext, "bienvenido ", Toast.LENGTH_SHORT).show()
                    val name = Intent(this, IniciActivity2::class.java)
                    startActivity(name)

                } else {
                    Toast.makeText(baseContext, "ERROR ", Toast.LENGTH_SHORT).show()
                }
            }
    }
}

    
