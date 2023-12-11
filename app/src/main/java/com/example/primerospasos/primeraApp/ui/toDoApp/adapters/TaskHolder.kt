package com.example.primerospasos.primeraApp.ui.toDoApp.adapters

import android.content.res.ColorStateList
import android.view.View
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.primerospasos.R
import com.example.primerospasos.databinding.ItemTodoTaskBinding
import com.example.primerospasos.primeraApp.ui.toDoApp.Task
import com.example.primerospasos.primeraApp.ui.toDoApp.TaskCategory
import com.example.primerospasos.primeraApp.ui.toDoApp.util.strikethroughText

class TaskHolder(view: View) : ViewHolder(view) {
    private val viewBinding = ItemTodoTaskBinding.bind(view)
    private val context = view.context
    fun render(task: Task) {
        viewBinding.tvTask.strikethroughText(applyStrikeThrough = task.isSelected)
        viewBinding.tvTask.text = task.name

        viewBinding.cbTask.isChecked = task.isSelected

        viewBinding.cbTask.buttonTintList = ColorStateList.valueOf(
            ContextCompat.getColor(
                context,
                when (task.category) {
                    TaskCategory.Business -> R.color.business_category
                    TaskCategory.Other -> R.color.other_category
                    TaskCategory.Personal -> R.color.personal_category
                }
            )
        )

    }
}
