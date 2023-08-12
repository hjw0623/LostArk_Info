package com.example.fp.retrofit

import com.example.fp.utils.Constants.BASE_URL
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object RetrofitClient {

    private var retrofitclient: Retrofit? = null

    fun getClient(baseUrl: String): Retrofit? {
        if (retrofitclient == null) {
            val client = OkHttpClient.Builder()
                .connectTimeout(30, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .writeTimeout(30,TimeUnit.SECONDS)
                .build()

             retrofitclient = Retrofit.Builder()
                .baseUrl(baseUrl)
                 .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        }
        return retrofitclient
    }

}