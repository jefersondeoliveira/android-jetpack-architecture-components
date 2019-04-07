package com.github.jefersondeoliveira.paging.util

import android.content.Context
import android.widget.Toast

fun Context.Toast(text: String?, duration: Int = Toast.LENGTH_SHORT){
    Toast.makeText(this, text, duration).show()
}