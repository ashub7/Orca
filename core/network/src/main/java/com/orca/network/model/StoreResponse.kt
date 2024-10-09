package com.orca.network.model

import com.google.gson.annotations.SerializedName

data class StoreResponse(
    var id: Int,
    val name: String,
    val domain: String,
    val slug: String,
    @SerializedName("game_count")
    val gameCount: Int,
    @SerializedName("image_background")
    val imageBackground: String,
    val description: String?
){
    var gameLink :String = ""
}