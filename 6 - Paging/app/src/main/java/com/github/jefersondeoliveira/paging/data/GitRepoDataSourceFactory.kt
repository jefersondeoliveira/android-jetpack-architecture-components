package com.github.jefersondeoliveira.paging.data

import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.github.jefersondeoliveira.paging.model.GitRepo

class GitRepoDataSourceFactory : DataSource.Factory<Int, GitRepo>() {

    val gitRepoLiveDataSource = MutableLiveData<GitRepoDataSource>()

    override fun create(): DataSource<Int, GitRepo> {

        val repoDataSouce = GitRepoDataSource()
        gitRepoLiveDataSource.postValue(repoDataSouce)
        return repoDataSouce

    }

}