package com.example.oraganizadtn

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyAdapter(private val userlist:ArrayList<User>):RecyclerView.Adapter<MyAdapter.Myviewholder>() {
  class Myviewholder(itemView:View):RecyclerView.ViewHolder(itemView){
      val actividad :TextView=itemView.findViewById(R.id.actividad)
      val hora :TextView=itemView.findViewById(R.id.hora)
      val fecha :TextView=itemView.findViewById(R.id.fecha)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Myviewholder {
 val itemView=LayoutInflater.from(parent.context).inflate(R.layout.list_item,parent,false)
    return Myviewholder((itemView))
    }

    override fun onBindViewHolder(holder: Myviewholder, position: Int) {
        val user:User=userlist[position]
        holder.actividad.text=user.Actividad
        holder.fecha.text=user.Fecha
        holder.hora.text=user.Hora

    }

    override fun getItemCount(): Int {
return userlist.size


    }
}