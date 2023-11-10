package com.example.proyecto2

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class Vista: ViewModel() {
    val pasaTexto = MutableLiveData<String>()
}