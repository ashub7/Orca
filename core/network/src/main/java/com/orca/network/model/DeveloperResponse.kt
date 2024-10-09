
package com.orca.network.model

import com.google.gson.annotations.SerializedName

data class DeveloperResponse(
    val id:Int,
    val name:String,
    val slug:String,
    val gameCount:Int,
    @SerializedName("image_background")
    val imageBackground:String,
    val description:String
)

