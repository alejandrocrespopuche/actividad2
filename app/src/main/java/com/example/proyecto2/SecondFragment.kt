package com.example.proyecto2

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

class SecondFragment : Fragment() {

    private lateinit var textView: TextView
    private lateinit var botonVolver: Button
    private lateinit var visor2: Vista


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        visor2 = ViewModelProvider(requireActivity())[Vista::class.java]
        val view = inflater.inflate(R.layout.fragment_second, container, false)
        textView = view.findViewById(R.id.saludo2)
        botonVolver = view.findViewById(R.id.button_second)
        
        visor2.pasaTexto.observe(viewLifecycleOwner, Observer {
                textView.text = "Hola $it !!!" 
            })
        
        botonVolver.setOnClickListener{
 
            requireActivity().supportFragmentManager.popBackStack()
        }

        return view
    }

    fun onTextoEnviado(it: String?) {

    }


}