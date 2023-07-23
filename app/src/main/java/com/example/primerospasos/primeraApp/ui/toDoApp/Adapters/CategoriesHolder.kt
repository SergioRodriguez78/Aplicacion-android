package com.example.primerospasos.primeraApp.ui.toDoApp.Adapters

import android.view.View
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.primerospasos.R
import com.example.primerospasos.databinding.ItemTaskCategoryBinding
import com.example.primerospasos.primeraApp.ui.toDoApp.TaskCategory

class CategoriesHolder(private val view: View) : RecyclerView.ViewHolder(view) {
    private val viewBinding = ItemTaskCategoryBinding.bind(view)

    fun render(taskCategory: TaskCategory) {
        when (taskCategory) {
            TaskCategory.Business -> {
                viewBinding.tvCategoryName.text = "Business"
                viewBinding.divider.setBackgroundColor(
                    ContextCompat.getColor(view.context, R.color.business_category)
                )
            }

            TaskCategory.Other -> {
                viewBinding.tvCategoryName.text = "Other"
                viewBinding.divider.setBackgroundColor(
                    ContextCompat.getColor(view.context, R.color.other_category)
                )
            }

            TaskCategory.Personal -> {
                viewBinding.tvCategoryName.text = "Personal"
                viewBinding.divider.setBackgroundColor(
                    ContextCompat.getColor(view.context, R.color.personal_category)
                )
            }
        }


    }
}