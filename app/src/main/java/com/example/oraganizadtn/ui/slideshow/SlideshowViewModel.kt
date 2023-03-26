package com.example.oraganizadtn.ui.slideshow

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SlideshowViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "EN MANTENIMIENTO ESPERA UNOS AÑOS MAS POR FAVOR"
    }
    val text: LiveData<String> = _text
}