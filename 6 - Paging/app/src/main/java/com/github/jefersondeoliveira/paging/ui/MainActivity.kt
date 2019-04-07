package com.github.jefersondeoliveira.paging.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.github.jefersondeoliveira.paging.R
import com.github.jefersondeoliveira.paging.data.GitRepoService
import com.github.jefersondeoliveira.paging.data.GitRepoServiceBuilder
import com.github.jefersondeoliveira.paging.model.GitRepo
import com.github.jefersondeoliveira.paging.model.GitResponse
import com.github.jefersondeoliveira.paging.util.Toast
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val adapter = GitAdapter()
        rvList.layoutManager = LinearLayoutManager(this)

        val viewModel: GitRepoViewModel = ViewModelProviders.of(this).get(GitRepoViewModel::class.java)

        viewModel.gitRepoPagedList.observe(this, Observer {
            adapter.submitList(it)
        })

        rvList.adapter = adapter

//        val service: GitRepoService = GitRepoServiceBuilder.buildService(GitRepoService::class.java)
//        val call: Call<GitResponse> = service.getRepositories(1, 10, "android")
//        call.enqueue(object: Callback<GitResponse>{
//            override fun onResponse(call: Call<GitResponse>, response: Response<GitResponse>) {
//                if(response.isSuccessful){
//                    val apiResponse: GitResponse = response.body()!!
//                    val responseItems: List<GitRepo>? = apiResponse.items
//                    val size: String? = responseItems?.let {
//                        it.size.toString()
//                    }
//                    Toast(size)
//
//                }
//            }
//            override fun onFailure(call: Call<GitResponse>, t: Throwable) {
//            }
//        })

    }
}
