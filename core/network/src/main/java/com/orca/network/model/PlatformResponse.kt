package com.orca.network.model

import com.google.gson.annotations.SerializedName

data class PlatformResponse(
    val id: Int,
    val name: String,
    val slug: String,
    @SerializedName("games_count")
    val gamesCount: Int,
    @SerializedName("image_background")
    val imageBackground: String,
    val image: String?,
    val imageUrl: String,
    val yearStart: Int,
    val yearEnd: Int?
)

data class PlatformParentSingleResponse(
    val id: Int,
    val name: String,
    val slug: String,
    val platforms: List<PlatformResponse>
)

data class GamePlatformResponse(
    val platform: PlatformResponse,
    @SerializedName("released_at")
    val releasedAt: String?, val requirements: RequirementResponse?
)

data class RequirementResponse(
    val minimum: String?,
    val recommended: String?
) {
    fun getAsString(): String {
        return minimum + "\n\n" + recommended
    }

    fun hasData() = minimum != null || recommended != null
}