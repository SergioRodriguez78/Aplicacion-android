package com.example.primerospasos.primeraApp.ui.toDoApp.Adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.example.primerospasos.R
import com.example.primerospasos.primeraApp.ui.toDoApp.Task

class TaskAdapter(private val tasks: List<Task>) : Adapter<TaskHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_todo_task, parent, false)
        return TaskHolder(view)
    }

    override fun getItemCount() = tasks.size

    override fun onBindViewHolder(holder: TaskHolder, position: Int) {
        holder.render(task = tasks[position])
    }
}
