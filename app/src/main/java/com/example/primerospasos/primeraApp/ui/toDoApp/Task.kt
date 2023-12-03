package com.example.primerospasos.primeraApp.ui.toDoApp

data class Task(val name: String, val category: TaskCategory, var isSelected: Boolean = false)
