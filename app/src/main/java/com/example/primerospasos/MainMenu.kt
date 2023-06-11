package com.example.primerospasos

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.primerospasos.databinding.ActivityLauncherrrrBinding
import com.example.primerospasos.primeraApp.ui.imc.ImcActivity
import com.example.primerospasos.primeraApp.ui.MainActivity
import com.example.primerospasos.primeraApp.ui.toDoApp.ToDoActivity

class MainMenu : AppCompatActivity() {

    lateinit var viewBinding: ActivityLauncherrrrBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        viewBinding= ActivityLauncherrrrBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(viewBinding.root)

        viewBinding.btnSaludar.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }

        viewBinding.btnImcApp.setOnClickListener {
            startActivity(Intent(this, ImcActivity::class.java))
        }

        viewBinding.btnToDo.setOnClickListener {
            startActivity(Intent(this, ToDoActivity::class.java))
        }

    }
}