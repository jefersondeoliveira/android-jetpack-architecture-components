package com.github.jefersondeoliveira.paging.data

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object GitRepoServiceBuilder {

    //Basic URL
    private const val URL = "https://api.github.com/"

    //Create Logger
    private val logger: HttpLoggingInterceptor
            = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

    //CreateOkHttp Client
    private val okHttp:OkHttpClient.Builder = OkHttpClient.Builder().addInterceptor(logger)

    //Create Retrofit builder
    private val builder: Retrofit.Builder = Retrofit.Builder().baseUrl(URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(okHttp.build())

    //Create Retrofit instance
    private val retrofit: Retrofit = builder.build()

    fun <T> buildService(serviceType: Class<T>): T{
        return retrofit.create(serviceType)
    }

}