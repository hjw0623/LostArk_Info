package com.example.fp.retrofit

import com.example.fp.response.CharacterInfo
import com.example.fp.response.Sibling
import com.example.fp.utils.Constants
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.Path

interface IRetrofit {

    @GET("/characters/{characterName}/siblings")
    fun searchCharacterSiblings(
        @Path("characterName") characterName: String,
        @Header("accept") acceptHeader: String,
        @Header("authorization") authorizationHeader: String
    ): Call<Sibling>

    @GET("/armories/characters/{characterName}")
    fun getCharacterInfo(
        @Path("characterName") characterName: String,
        @Header("accept") acceptHeader: String,
        @Header("authorization") authorizationHeader: String
    ): Call<CharacterInfo>









}