package com.example.oraganizadtn

import android.content.Context
import android.content.Intent
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.ktx.Firebase

fun Context.login(){
    val intent = Intent(this,loginActivity2::class.java).apply {

        flags=Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
    }
    startActivity(intent)

}
fun Context.cerrar(){
    FirebaseAuth.getInstance().signOut()

    val intent = Intent(this,MainActivity::class.java).apply {

        flags=Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
    }
    startActivity(intent)


}


