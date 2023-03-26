package com.example.oraganizadtn.ui.gallery

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.oraganizadtn.MyAdapter
import com.example.oraganizadtn.R
import com.example.oraganizadtn.User
import com.example.oraganizadtn.databinding.FragmentGalleryBinding
import com.google.firebase.firestore.*
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class GalleryFragment : Fragment() {
    lateinit var recyclerView: RecyclerView
    lateinit var userArray:ArrayList<User>
    lateinit var myAdapter: MyAdapter
    lateinit var db: FirebaseFirestore
    private var _binding: FragmentGalleryBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val galleryViewModel =
            ViewModelProvider(this).get(GalleryViewModel::class.java)

        _binding = FragmentGalleryBinding.inflate(inflater, container, false)
        val root: View = binding.root
        recyclerView=root.findViewById(R.id.recycleview)
        recyclerView.layoutManager= LinearLayoutManager(requireContext())
        recyclerView.setHasFixedSize(true)

        userArray= arrayListOf()

        myAdapter=MyAdapter(userArray)
        recyclerView.adapter=myAdapter

        listarDatos()





       // val textView: TextView = binding.textGallery
        galleryViewModel.text.observe(viewLifecycleOwner) {
           // textView.text = it
        }
        return root


    }

    private fun listarDatos() {

            db = FirebaseFirestore.getInstance()
            db.collection("DRINER").addSnapshotListener(object : EventListener<QuerySnapshot> {
                override fun onEvent(
                    value: QuerySnapshot?,
                    error: FirebaseFirestoreException?

                ) {
                    if (error != null) {
                        Log.e("firestorreerrp", error.message.toString())
                        return
                    }
                    for (dc: DocumentChange in value?.documentChanges!!) {


                        if (dc.type == DocumentChange.Type.ADDED) {
                            userArray.add(dc.document.toObject(User::class.java))
                        }
                    }
                    myAdapter.notifyDataSetChanged()
                }


            })
        }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}