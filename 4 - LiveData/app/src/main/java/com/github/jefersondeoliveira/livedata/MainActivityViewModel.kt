package com.github.jefersondeoliveira.livedata
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.util.Log
import java.util.*

class MainActivityViewModel : ViewModel(){

    private lateinit var myRamdonNumber: MutableLiveData<String>

    fun getNumber(): MutableLiveData<String>{
        Log.i(TAG, "Get number")
        if(!::myRamdonNumber.isInitialized){
            myRamdonNumber = MutableLiveData()
            this.createNumber()
        }
        return myRamdonNumber
    }

    fun createNumber(){
        Log.i(TAG, "Create new number")
        val random = Random()
        myRamdonNumber.value = "Number: "+(random.nextInt(10-1)+1)
    }

    companion object {
        private val TAG: String? = MainActivityViewModel::class.java.simpleName
    }
}