package com.github.jefersondeoliveira.livedata
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val model: MainActivityViewModel = ViewModelProviders.of(this)
            .get(MainActivityViewModel::class.java)

        val myRamdonNumber: MutableLiveData<String> = model.getNumber()

        myRamdonNumber.observe(this, Observer<String> { number ->
            tvRamdon.text = number
            Log.i(TAG, "set Ramdon number")
        })

        btRamdon.setOnClickListener{
            model.createNumber()
        }

    }

    companion object {
        private var TAG: String? = MainActivity::class.java.simpleName
    }
}
