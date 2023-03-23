package com.example.oraganizadtn.ui.gallery

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.oraganizadtn.R
import com.example.oraganizadtn.databinding.FragmentGalleryBinding

class GalleryFragment : Fragment() {
    lateinit var  ArrayAdapter: ArrayAdapter<*>
private var activades = emptyArray<String>()
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
        val activades = arrayOf(

            "Driner",
            "Mario",
            "Marcos",
            "Kalifa",
            "Gorge"
        )
        var iadap=ArrayAdapter<String>(requireContext(), android.R.layout.simple_list_item_1,activades)
        binding.listaactivades.adapter=iadap
       // val textView: TextView = binding.textGallery
        galleryViewModel.text.observe(viewLifecycleOwner) {
           // textView.text = it
        }
        return root


    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}