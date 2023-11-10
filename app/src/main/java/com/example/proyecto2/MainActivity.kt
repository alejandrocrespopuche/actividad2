package com.example.proyecto2


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider


class MainActivity : AppCompatActivity() {

    private lateinit var vista: Vista
    private lateinit var fragment1: FirstFragment
    private lateinit var fragment2: SecondFragment


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.main_activity)

        vista = ViewModelProvider(this)[Vista::class.java]
        fragment1 = FirstFragment()
        fragment2 = SecondFragment()


        supportFragmentManager.beginTransaction()
            .replace(R.id.contenedor, fragment1)
            .commit()

        vista.pasaTexto.observe(this, Observer {
            fragment2.onTextoEnviado(it)
            supportFragmentManager.beginTransaction()
                .replace(R.id.contenedor, fragment2)
                .addToBackStack(null)
                .commit()
        })
    }
}

