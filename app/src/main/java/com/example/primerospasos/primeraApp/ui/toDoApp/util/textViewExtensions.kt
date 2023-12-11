package com.example.primerospasos.primeraApp.ui.toDoApp.util

import android.graphics.Paint
import android.widget.TextView

fun TextView.strikethroughText(applyStrikeThrough: Boolean) {
    paintFlags = if (applyStrikeThrough) {
        paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
    } else {
        paintFlags and Paint.STRIKE_THRU_TEXT_FLAG.inv()
    }
}
