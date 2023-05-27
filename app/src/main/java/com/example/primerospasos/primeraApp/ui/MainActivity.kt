package com.example.primerospasos.primeraApp.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.widget.AppCompatEditText
import com.example.primerospasos.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        //Al arrancar pantalla

        val btnStart = findViewById<Button>(R.id.button)
        val etName = findViewById<AppCompatEditText>(R.id.etName)




        btnStart.setOnClickListener {
            val name = etName.text.toString()

            navigateToResultado(name)


        }

    }

    private fun navigateToResultado(name: String) {
        val intent = Intent(this, ResultadoActivity::class.java)
        intent.putExtra("EXTRA_NAME", name)
        startActivity(intent)
    }
}