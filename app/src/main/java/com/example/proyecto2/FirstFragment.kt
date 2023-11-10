package com.example.proyecto2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider



class FirstFragment : Fragment() {

    private lateinit var visor: Vista

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_first, container, false)

        visor = ViewModelProvider(requireActivity())[Vista::class.java]

        val editText = view.findViewById<EditText>(R.id.saludo)
        val enviarButton = view.findViewById<Button>(R.id.button_first)

        enviarButton.setOnClickListener {
            val texto = editText.text.toString()
            visor.pasaTexto.value = texto
        }

        return view
    }
}