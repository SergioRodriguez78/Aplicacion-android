package com.example.primerospasos.primeraApp.ui.toDoApp.adapters

import android.view.View
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.primerospasos.R
import com.example.primerospasos.databinding.ItemTaskCategoryBinding
import com.example.primerospasos.primeraApp.ui.toDoApp.TaskCategory

class CategoriesHolder(private val view: View) : RecyclerView.ViewHolder(view) {
    private val viewBinding = ItemTaskCategoryBinding.bind(view)
    private val resources = viewBinding.root.context.resources

    fun render(taskCategory: TaskCategory, onItemSelected: (Int) -> Unit) {

        viewBinding.categoryCard.setCardBackgroundColor(
            if (taskCategory.isSelected) {
                ContextCompat.getColor(view.context, R.color.background_disabled)
            } else ContextCompat.getColor(view.context, R.color.background_card)
        )

        itemView.setOnClickListener { onItemSelected(layoutPosition) }

        when (taskCategory) {
            TaskCategory.Business -> {
                viewBinding.tvCategoryName.text = resources.getString(R.string.Business)
                viewBinding.divider.setBackgroundColor(
                    ContextCompat.getColor(view.context, R.color.business_category)
                )
            }

            TaskCategory.Other -> {
                viewBinding.tvCategoryName.text = resources.getString(R.string.Other)
                viewBinding.divider.setBackgroundColor(
                    ContextCompat.getColor(view.context, R.color.other_category)
                )
            }

            TaskCategory.Personal -> {
                viewBinding.tvCategoryName.text = resources.getString(R.string.Personal)
                viewBinding.divider.setBackgroundColor(
                    ContextCompat.getColor(view.context, R.color.personal_category)
                )
            }
        }


    }
}
