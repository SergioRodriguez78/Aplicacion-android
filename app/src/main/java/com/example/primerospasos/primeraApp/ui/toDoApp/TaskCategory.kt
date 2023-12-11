package com.example.primerospasos.primeraApp.ui.toDoApp

sealed class TaskCategory(var isSelected: Boolean = false) {
    object Personal : TaskCategory()
    object Business : TaskCategory()
    object Other : TaskCategory()

}
