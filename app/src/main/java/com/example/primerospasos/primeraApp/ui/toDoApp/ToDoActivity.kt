package com.example.primerospasos.primeraApp.ui.toDoApp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.primerospasos.R
import com.example.primerospasos.databinding.ActivityToDoBinding
import com.example.primerospasos.primeraApp.ui.toDoApp.Adapters.CategoriesAdapter


class ToDoActivity : AppCompatActivity() {

    lateinit var viewBinding: ActivityToDoBinding
    private val categories = listOf<TaskCategory>(
        TaskCategory.Business,
        TaskCategory.Personal,
        TaskCategory.Other
    )


    override fun onCreate(savedInstanceState: Bundle?) {
        viewBinding= ActivityToDoBinding.inflate(layoutInflater)

        super.onCreate(savedInstanceState)
        setContentView(viewBinding.root)


        //add orientation to the recycler view
        viewBinding.rvCategories.layoutManager= LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        viewBinding.rvCategories.adapter = CategoriesAdapter(categories = categories)

    }
}