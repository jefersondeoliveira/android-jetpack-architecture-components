package com.github.jefersondeoliveira.paging.data

import androidx.paging.PageKeyedDataSource
import com.github.jefersondeoliveira.paging.model.GitRepo
import com.github.jefersondeoliveira.paging.model.GitResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class GitRepoDataSource : PageKeyedDataSource<Int, GitRepo>() {

    override fun loadInitial(params: LoadInitialParams<Int>, callback: LoadInitialCallback<Int, GitRepo>) {

        val service: GitRepoService = GitRepoServiceBuilder.buildService(GitRepoService::class.java)
        val call: Call<GitResponse> = service.getRepositories(FIST_PAGE, PAGE_SIZE, TOPIC)

        call.enqueue(object : Callback<GitResponse>{

            override fun onResponse(call: Call<GitResponse>, response: Response<GitResponse>) {

                if(response.isSuccessful){
                    val apiResponse: GitResponse = response.body()!!
                    val responseItems: List<GitRepo>? = apiResponse.items
                    responseItems?.let {
                        callback.onResult(responseItems, null, FIST_PAGE.inc())
                    }

                }

            }

            override fun onFailure(call: Call<GitResponse>, t: Throwable) {
            }

        })

    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, GitRepo>) {
        val service: GitRepoService = GitRepoServiceBuilder.buildService(GitRepoService::class.java)
        val call: Call<GitResponse> = service.getRepositories(params.key, PAGE_SIZE, TOPIC)

        call.enqueue(object : Callback<GitResponse>{

            override fun onResponse(call: Call<GitResponse>, response: Response<GitResponse>) {

                if(response.isSuccessful){
                    val apiResponse: GitResponse = response.body()!!
                    val responseItems: List<GitRepo>? = apiResponse.items

                    val key: Int = if(apiResponse.totalCount > params.key) params.key.inc() else 0

                    responseItems?.let {
                        callback.onResult(responseItems, key)
                    }

                }

            }

            override fun onFailure(call: Call<GitResponse>, t: Throwable) {
            }

        })
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, GitRepo>) {
        val service: GitRepoService = GitRepoServiceBuilder.buildService(GitRepoService::class.java)
        val call: Call<GitResponse> = service.getRepositories(params.key, PAGE_SIZE, TOPIC)

        call.enqueue(object : Callback<GitResponse>{

            override fun onResponse(call: Call<GitResponse>, response: Response<GitResponse>) {

                if(response.isSuccessful){
                    val apiResponse: GitResponse = response.body()!!
                    val responseItems: List<GitRepo>? = apiResponse.items

                    val key: Int = if(apiResponse.totalCount > 1) params.key.dec() else 0

                    responseItems?.let {
                        callback.onResult(responseItems, key)
                    }

                }

            }

            override fun onFailure(call: Call<GitResponse>, t: Throwable) {
            }

        })
    }

    companion object {

        const val PAGE_SIZE = 10
        const val FIST_PAGE = 1
        const val TOPIC = "android"

    }

}