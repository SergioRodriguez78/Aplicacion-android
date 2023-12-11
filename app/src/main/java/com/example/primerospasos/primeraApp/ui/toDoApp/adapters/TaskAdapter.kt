package com.example.primerospasos.primeraApp.ui.toDoApp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.example.primerospasos.databinding.ItemTodoTaskBinding
import com.example.primerospasos.primeraApp.ui.toDoApp.Task

class TaskAdapter(var tasks: List<Task>, private val onTaskSelected: (Int) -> Unit) :
    Adapter<TaskHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskHolder {
        val inflater = LayoutInflater.from(parent.context)
        val viewBinding = ItemTodoTaskBinding.inflate(inflater, parent, false)
        return TaskHolder(viewBinding.root)
    }

    override fun getItemCount() = tasks.size

    override fun onBindViewHolder(holder: TaskHolder, position: Int) {
        holder.render(task = tasks[position])
        holder.itemView.setOnClickListener { onTaskSelected(position) }
    }
}
