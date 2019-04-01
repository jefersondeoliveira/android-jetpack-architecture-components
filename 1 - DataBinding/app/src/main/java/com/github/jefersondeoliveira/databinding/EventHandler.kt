package com.github.jefersondeoliveira.databinding

import android.content.Context
import android.widget.Toast

open class EventHandler(context:Context){

    val myContext:Context = context

    fun onClickButton(name:String){
        Toast.makeText(myContext, "Hello "+name, Toast.LENGTH_LONG).show()
    }

}