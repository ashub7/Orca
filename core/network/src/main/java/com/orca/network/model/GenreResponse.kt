
package com.orca.network.model

data class GenreResponse(
    val id:Int,
    val name:String,
    val slug:String,
    val gamesCount:Int?,
    val imageBackgroundURL:String?,
    val description:String?
)

