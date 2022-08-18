package com.example.mypost

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
//retrofit is a library that creates Apiclient
//re
//interface is a point of interaction btn two sytems of a program
object ApiClient {
    var retrofit = Retrofit.Builder()
        .baseUrl("https://jsonplaceholder.typicode.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun <T> buildApiClient(apiInterface: Class<T>): T {
        return retrofit.create(apiInterface)

    }
}
//io thread receives response
