package com.example.primerospasos.primeraApp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import com.example.primerospasos.R

class ResultadoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultado)

        val txtResult = findViewById<TextView>(R.id.textView)
        val name: String = intent.extras?.getString("EXTRA_NAME").orEmpty()
        Log.i("prueba", "Recibido $name")
        txtResult.text = "Hola ${name}"


    }
}