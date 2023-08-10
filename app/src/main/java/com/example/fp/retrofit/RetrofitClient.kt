package com.example.fp.retrofit

import com.example.fp.utils.Constants.BASE_URL
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {

    private var retrofitclient: Retrofit? = null

    fun getClient(baseUrl: String): Retrofit? {
        if (retrofitclient == null) {
             retrofitclient = Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        }
        return retrofitclient
    }
}