package com.orca.network.model

data class CreatorResponse(
    val id: Int,
    val name: String,
    val slug: String,
    val imageURL: String,
    val imageBackgroundURL: String,
    val gameCount: Int,
    val description:String,
    val reviewsCount:Int,
    val rating:String,
    val ratingTop:Int,
    val updated:String
)
