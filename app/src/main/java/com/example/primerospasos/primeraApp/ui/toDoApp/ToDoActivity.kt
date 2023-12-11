package com.example.primerospasos.primeraApp.ui.toDoApp

import android.annotation.SuppressLint
import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.RadioButton
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.primerospasos.R
import com.example.primerospasos.databinding.ActivityToDoBinding
import com.example.primerospasos.databinding.DialogTaskBinding
import com.example.primerospasos.primeraApp.ui.toDoApp.TaskCategory.Business
import com.example.primerospasos.primeraApp.ui.toDoApp.TaskCategory.Other
import com.example.primerospasos.primeraApp.ui.toDoApp.TaskCategory.Personal
import com.example.primerospasos.primeraApp.ui.toDoApp.adapters.CategoriesAdapter
import com.example.primerospasos.primeraApp.ui.toDoApp.adapters.TaskAdapter


class ToDoActivity : AppCompatActivity() {

    private lateinit var viewBindingActivity: ActivityToDoBinding
    private lateinit var viewBindingDialog: DialogTaskBinding

    private val categories = listOf(
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

        viewBindingActivity = ActivityToDoBinding.inflate(layoutInflater)

        super.onCreate(savedInstanceState)
        setContentView(viewBindingActivity.root)

        viewBindingActivity.fabAddTask.setOnClickListener {
            showDialog()
        }

        setCategoriesRv()
        setTaskRv()

    }

    private fun setCategoriesRv() {
        //add orientation to the recycler view
        viewBindingActivity.rvCategories.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        viewBindingActivity.rvCategories.adapter =
            CategoriesAdapter(categories = categories) { updateCategories(it) }
    }

    private fun updateCategories(position: Int) {
        categories[position].isSelected = !categories[position].isSelected
        viewBindingActivity.rvCategories.adapter?.notifyItemChanged(position)

        filterTasks()
    }

    private fun setTaskRv() {
        viewBindingActivity.rvTasks.layoutManager = LinearLayoutManager(this)
        viewBindingActivity.rvTasks.adapter = TaskAdapter(tasks) { onItemSelected(it) }
    }

    private fun onItemSelected(position: Int) {
        tasks[position].isSelected = !tasks[position].isSelected
        viewBindingActivity.rvTasks.adapter?.notifyItemChanged(position)
    }

    private fun showDialog() {
        val dialog = Dialog(this)
        viewBindingDialog = DialogTaskBinding.inflate(LayoutInflater.from(this))
        dialog.setContentView(viewBindingDialog.root)

        viewBindingDialog.addTask.setOnClickListener {
            if (!viewBindingDialog.etTask.text.isNullOrEmpty()) {
                addTask()
                dialog.dismiss()
            }
        }
        dialog.show()
    }

    private fun addTask() {
        val rbSelectedId = viewBindingDialog.rgCategories.checkedRadioButtonId
        val rbSelected = viewBindingDialog.rgCategories.findViewById<RadioButton>(rbSelectedId)
        val category = when (rbSelected.text) {
            getString(R.string.negocios) -> Business
            getString(R.string.Personal) -> Personal
            getString(R.string.other) -> Other
            else -> Other
        }
        addTaskToAdapter(category)
    }


    private fun addTaskToAdapter(category: TaskCategory) {
        tasks.add(
            Task(
                name = viewBindingDialog.etTask.text.toString(),
                category = category
            )
        )
        val insertedPosition = tasks.size - 1

        viewBindingActivity.rvTasks.adapter?.notifyItemInserted(insertedPosition)
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun filterTasks() {
        val selectedCategories: List<TaskCategory> =
            categories.filter { category -> category.isSelected }
        val newTask = if (selectedCategories.isNotEmpty()) {
            tasks.filter { task -> selectedCategories.contains(task.category) }
        } else {
            tasks
        }

        val adapter = viewBindingActivity.rvTasks.adapter as? TaskAdapter
        adapter?.tasks = newTask
        viewBindingActivity.rvTasks.adapter?.notifyDataSetChanged()
    }
}
