package com.github.jefersondeoliveira.viewmodel

import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.github.jefersondeoliveira.viewmodel.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var data: MainActivityDataGenarator

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding : ActivityMainBinding = DataBindingUtil.setContentView(
            this, R.layout.activity_main)

        val model: MainActivityDataGenarator = ViewModelProviders.of(this).get(MainActivityDataGenarator::class.java)

        //without iewModel data is lost when activity is recreated (rotation)
//        data = MainActivityDataGenarator()
//        val myRamdonNumber: String = data.getNumber()
//        binding.number = myRamdonNumber
//        Log.i(TAG, "set Ramdon number")

        //with viewModel safe data
        val myRamdonNumber: String = model.getNumber()
        binding.number = myRamdonNumber
        Log.i(TAG, "set Ramdon number")

    }

    companion object {
        private var TAG: String? = MainActivity::class.java.simpleName
    }
}
