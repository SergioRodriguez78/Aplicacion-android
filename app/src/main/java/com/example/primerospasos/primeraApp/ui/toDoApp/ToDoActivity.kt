package com.example.primerospasos.primeraApp.ui.toDoApp

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.RadioButton
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.primerospasos.R
import com.example.primerospasos.databinding.ActivityToDoBinding
import com.example.primerospasos.databinding.DialogTaskBinding
import com.example.primerospasos.primeraApp.ui.toDoApp.Adapters.CategoriesAdapter
import com.example.primerospasos.primeraApp.ui.toDoApp.Adapters.TaskAdapter
import com.example.primerospasos.primeraApp.ui.toDoApp.TaskCategory.*


class ToDoActivity : AppCompatActivity() {

    lateinit var viewBindingActivity: ActivityToDoBinding
    lateinit var viewBindingDialog: DialogTaskBinding

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
        viewBindingActivity.rvCategories.adapter = CategoriesAdapter(categories = categories)
    }

    private fun setTaskRv() {
        viewBindingActivity.rvTasks.layoutManager = LinearLayoutManager(this)
        viewBindingActivity.rvTasks.adapter = TaskAdapter(tasks)
    }

    private fun showDialog() {
        val dialog = Dialog(this)
        viewBindingDialog = DialogTaskBinding.inflate(LayoutInflater.from(this))
        dialog.setContentView(viewBindingDialog.root)
        dialog.show()

        viewBindingDialog.addTask.setOnClickListener {
            addTask()
            dialog.hide()
        }
    }

    private fun addTask() {
        val rbSelectedId = viewBindingDialog.rgCategories.checkedRadioButtonId
        val rbSelected = viewBindingDialog.rgCategories.findViewById<RadioButton>(rbSelectedId)
        val category = when (rbSelected.text) {
            getString(R.string.Business) -> Business
            getString(R.string.Personal) -> Personal
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
}
