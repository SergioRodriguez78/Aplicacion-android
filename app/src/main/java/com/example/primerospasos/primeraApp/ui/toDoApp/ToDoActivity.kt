package com.example.primerospasos.primeraApp.ui.toDoApp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.primerospasos.databinding.ActivityToDoBinding
import com.example.primerospasos.primeraApp.ui.toDoApp.Adapters.CategoriesAdapter
import com.example.primerospasos.primeraApp.ui.toDoApp.Adapters.TaskAdapter
import com.example.primerospasos.primeraApp.ui.toDoApp.TaskCategory.*


class ToDoActivity : AppCompatActivity() {

    lateinit var viewBinding: ActivityToDoBinding
    private val categories = listOf<TaskCategory>(
        Business,
        Personal,
        Other
    )
    private val tasks = mutableListOf(
        Task(name = "pruebaBusiness", Business),
        Task(name = "pruebaPersonal", Personal),
        Task(name = "pruebaOther", Other)
    )


    override fun onCreate(savedInstanceState: Bundle?) {
        viewBinding = ActivityToDoBinding.inflate(layoutInflater)

        super.onCreate(savedInstanceState)
        setContentView(viewBinding.root)


        //add orientation to the recycler view
        viewBinding.rvCategories.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        viewBinding.rvCategories.adapter = CategoriesAdapter(categories = categories)

        viewBinding.rvTasks.layoutManager = LinearLayoutManager(this)
        viewBinding.rvTasks.adapter = TaskAdapter(tasks)

    }
}