package com.github.jefersondeoliveira.paging.model

import com.google.gson.annotations.SerializedName

class GitRepo{

    @field:SerializedName("full_name")
    var fullName: String? = null
    var description : String? = null
    @field:SerializedName("stargazers_count")
    var starts: Int = 0
    @field:SerializedName("forks_count")
    var forks: Int = 0

}

class GitResponse{

    @field:SerializedName("total_count")
    var totalCount: Int = 0
    var items: List<GitRepo>? = null

}