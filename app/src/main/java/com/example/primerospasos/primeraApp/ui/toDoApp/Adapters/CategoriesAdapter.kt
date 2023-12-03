package com.example.primerospasos.primeraApp.ui.toDoApp.Adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.primerospasos.databinding.ItemTaskCategoryBinding
import com.example.primerospasos.primeraApp.ui.toDoApp.TaskCategory


class CategoriesAdapter(private val categories: List<TaskCategory>) :
    RecyclerView.Adapter<CategoriesHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoriesHolder {
        val viewBinding = ItemTaskCategoryBinding.inflate(LayoutInflater.from(parent.context))
        return CategoriesHolder(viewBinding.root)
    }

    override fun getItemCount(): Int = categories.size

    override fun onBindViewHolder(holder: CategoriesHolder, position: Int) {
        holder.render(categories[position])
    }

}
