package com.example.primerospasos.primeraApp.ui.toDoApp.Adapters

import android.view.View
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.primerospasos.databinding.ItemTodoTaskBinding
import com.example.primerospasos.primeraApp.ui.toDoApp.Task

class TaskHolder(view: View) : ViewHolder(view) {
    private val viewBinding = ItemTodoTaskBinding.bind(view)
    fun render(task: Task) {
        viewBinding.tvTask.text = task.name

    }

}
