package com.example.oraganizadtn.ui.home

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.oraganizadtn.IniciActivity2
import com.example.oraganizadtn.R
import com.example.oraganizadtn.Tampiker
import com.example.oraganizadtn.databinding.FragmentHomeBinding
import com.example.oraganizadtn.ui.gallery.GalleryFragment
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestoreSettings
import java.util.*

class HomeFragment : Fragment() {
    val db = FirebaseFirestore.getInstance()
    val today = Calendar.getInstance()

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root


        val hora: TextView = root.findViewById(R.id.bt)
        val fecha: TextView = root.findViewById(R.id.horasel)
        val datos :EditText=root.findViewById(R.id.datos1)
         val horaicon:ImageButton=root.findViewById(R.id.imageButton2)
        val horaicon2:ImageButton=root.findViewById(R.id.imageButton)
        val driner : String="DRINER"
        horaicon.setOnClickListener{
    cliken2()
}

        hora.setOnClickListener {
            val startHour=today.get(Calendar.HOUR_OF_DAY)
            val stackMi=today.get(Calendar.MINUTE)
            TimePickerDialog(this.context, TimePickerDialog.OnTimeSetListener { TimePicker, i, i2 ->
                hora.setText("$i:$i2")
            }, startHour, stackMi, false).show()
         }
        horaicon2.setOnClickListener {
            cliken2()
        }


        fecha.setOnClickListener{

            DatePickerDialog( requireContext(),DatePickerDialog.OnDateSetListener{ DatePicker, a, e, b ->
            fecha.setText("$a/$e/$b")
            },2007,7,8).show()
         }


        binding.bt3.setOnClickListener {
            val user = hashMapOf(
                "Actividad" to binding.datos1.text.toString(),
                "Fecha" to binding.horasel.text.toString(),
                "Hora" to binding.bt.text.toString()


            )
            db.collection(driner).document(datos.text.toString())
                .set(user)
                .addOnSuccessListener { documentReference->
                    Toast.makeText(requireContext(), "Datos guardados", Toast.LENGTH_SHORT).show()

                }
        }



        val textView: TextView = binding.textHome
        homeViewModel.text.observe(viewLifecycleOwner) {

        }
        return root
    }

    fun clikfecha2(){

        DatePickerDialog( requireContext(),DatePickerDialog.OnDateSetListener{ DatePicker, a, e, b ->

        },2007,7,8).show()
    }
     private fun cliken2 (){
        val startHour=today.get(Calendar.HOUR_OF_DAY)
        val stackMi=today.get(Calendar.MINUTE)
        TimePickerDialog(this.context, TimePickerDialog.OnTimeSetListener { TimePicker, i, i2 ->
        }, startHour, stackMi, false).show()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}