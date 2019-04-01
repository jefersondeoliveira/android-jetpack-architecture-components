package com.github.jefersondeoliveira.databinding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.github.jefersondeoliveira.databinding.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding : ActivityMainBinding = DataBindingUtil.setContentView(
            this, R.layout.activity_main)

//        binding.tvName.text = "Teste"
//        binding.tvEmail.text = "teste@teste.com"
        binding.contact = Contact("Jeferson", "jeferson.lopes@zup.com.br")
        binding.eventHandler = EventHandler(this)
        binding.imageUrl = "https://upload.wikimedia.org/wikipedia/en/0/0d/Avengers_Endgame_poster.jpg"
    }
}
