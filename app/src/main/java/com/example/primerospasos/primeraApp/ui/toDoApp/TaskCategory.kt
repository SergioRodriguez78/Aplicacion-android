package com.example.primerospasos.primeraApp.ui.toDoApp

sealed class TaskCategory {
    object Personal : TaskCategory()
    object Business : TaskCategory()
    object Other : TaskCategory()

}
