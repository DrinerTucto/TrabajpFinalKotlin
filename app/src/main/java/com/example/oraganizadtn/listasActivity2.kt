package com.example.oraganizadtn

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.firestore.DocumentChange
import com.google.firebase.firestore.EventListener
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.FirebaseFirestoreException
import com.google.firebase.firestore.QuerySnapshot
import com.google.firebase.ktx.Firebase

class listasActivity2 : AppCompatActivity() {
    lateinit var recyclerView: RecyclerView
    lateinit var userArray:ArrayList<User>
    lateinit var myAdapter:MyAdapter
    lateinit var db:FirebaseFirestore
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_listas2)
        recyclerView=findViewById(R.id.recycleview)
        recyclerView.layoutManager=LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)

        userArray= arrayListOf()

        myAdapter=MyAdapter(userArray)
        recyclerView.adapter=myAdapter

        listarDatos()

    }

    private fun listarDatos() {

        db = FirebaseFirestore.getInstance()
        db.collection("usuarios").
            addSnapshotListener(object :EventListener<QuerySnapshot>{
                override fun onEvent(
                    value: QuerySnapshot?,
                    error: FirebaseFirestoreException?

            ){
                        if (error!=null){
                    Log.e("firestorreerrp",error.message.toString())
                        return
                        }
                    for (dc : DocumentChange in value?.documentChanges!!){


                        if (dc.type==DocumentChange.Type.ADDED){
                            userArray.add(dc.document.toObject(User::class.java))
                        }
                    }
                    myAdapter.notifyDataSetChanged()
                   }


            })
    }
    }
