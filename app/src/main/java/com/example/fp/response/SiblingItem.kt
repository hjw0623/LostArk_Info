package com.example.fp.response


import com.google.gson.annotations.SerializedName

data class SiblingItem(
    @SerializedName("CharacterClassName")
    val characterClassName: String,
    @SerializedName("CharacterLevel")
    val characterLevel: Int,
    @SerializedName("CharacterName")
    val characterName: String,
    @SerializedName("ItemAvgLevel")
    val itemAvgLevel: String,
    @SerializedName("ItemMaxLevel")
    val itemMaxLevel: String,
    @SerializedName("ServerName")
    val serverName: String
)