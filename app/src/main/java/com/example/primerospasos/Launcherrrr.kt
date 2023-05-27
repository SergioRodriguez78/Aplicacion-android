package com.example.primerospasos

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.primerospasos.primeraApp.ui.imc.ImcActivity
import com.example.primerospasos.primeraApp.ui.MainActivity

class Launcherrrr : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_launcherrrr)

        val btonSaludar= findViewById<Button>(R.id.btnSaludar)
        val btonImc= findViewById<Button>(R.id.btnImcApp)

        btonSaludar.setOnClickListener {
            navigateToSaludar()
        }
        btonImc.setOnClickListener {
            navigateToImc()
        }
    }

   private fun navigateToSaludar(){
        val intent= Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
    private fun navigateToImc(){
        val intent= Intent(this, ImcActivity::class.java)
        startActivity(intent)
    }
}