package com.orca.network.model.base

import com.google.gson.annotations.SerializedName

data class PagedResponse<T>(
    @SerializedName("count")
    val count: Int,
    @SerializedName("next")
    val next: String?,
    @SerializedName("previous")
    var prev: String?,
    @SerializedName("results")
    var result: List<T>
)

