package com.github.jefersondeoliveira.viewmodel

import android.arch.lifecycle.ViewModel
import android.util.Log
import java.util.*

class MainActivityDataGenarator : ViewModel(){

    private lateinit var myRamdonNumber: String

    fun getNumber(): String{
        Log.i(TAG, "Get number")
        if(!::myRamdonNumber.isInitialized){
            this.createNumber()
        }
        return myRamdonNumber
    }

    fun createNumber(){
        Log.i(TAG, "Create new number")
        val random = Random()
        myRamdonNumber = "Number: "+(random.nextInt(10-1)+1)
    }

    companion object {
        private val TAG: String? = MainActivityDataGenarator::class.java.simpleName
    }
}