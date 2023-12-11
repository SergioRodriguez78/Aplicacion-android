package com.example.primerospasos.primeraApp.ui.toDoApp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.primerospasos.databinding.ItemTaskCategoryBinding
import com.example.primerospasos.primeraApp.ui.toDoApp.TaskCategory


class CategoriesAdapter(
    private val categories: List<TaskCategory>,
    private val onItemSelected: (Int) -> Unit
) :
    RecyclerView.Adapter<CategoriesHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoriesHolder {
        val inflater = LayoutInflater.from(parent.context)
        val viewBinding = ItemTaskCategoryBinding.inflate(inflater, parent, false)
        return CategoriesHolder(viewBinding.root)
    }

    override fun getItemCount(): Int = categories.size

    override fun onBindViewHolder(holder: CategoriesHolder, position: Int) {
        holder.render(categories[position], onItemSelected)
    }

}
