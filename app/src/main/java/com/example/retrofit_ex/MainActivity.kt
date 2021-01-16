package com.example.retrofit_ex

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val apiService = ApiService()

        val call = apiService.getAlbums()

        val textView = findViewById<TextView>(R.id.textview)
        call.enqueue(object: Callback<List<Album>>{
            override fun onResponse(call: Call<List<Album>>, response: Response<List<Album>>) {
                if (response.isSuccessful){

                    textView.text = response.body().toString()

                }
            }

            override fun onFailure(call: Call<List<Album>>, t: Throwable) {
                Log.d("API",t.message)
            }
        })
    }
}