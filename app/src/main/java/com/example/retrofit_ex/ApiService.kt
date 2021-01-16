package com.example.retrofit_ex

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET



val BASE_URL = "https://jsonplaceholder.typicode.com"
interface ApiService {

    @GET("/albums")
    fun getAlbums(): Call<List<Album>>



    companion object{
        operator fun invoke(): ApiService{
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ApiService::class.java)
        }
    }
}