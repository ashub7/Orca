package com.orca.network.model

import com.google.gson.annotations.SerializedName
import java.util.*

data class GameResponse(
    var id: Int,
    var slug: String,
    var name: String,
    var released: String,
    @SerializedName("background_image")
    var backgroundImage: String?,
    var rating: Double,
    @SerializedName("rating_top")
    var ratingTop: Int,
    @SerializedName("ratings_count")
    var ratingsCount: Int,
    @SerializedName("reviews_text_count")
    var reviewsTextCount: Int?,
    var metacritic: Int?,
    @SerializedName("suggestions_count")
    var suggestionsCount: Int,
    @SerializedName("short_screenshots")
    var shortScreenshots: List<ShortScreenshot>,
    var genres: List<GenreResponse>,
    val platforms: List<GamePlatformResponse>?
    )

data class ShortScreenshot(
    val id: Int,
    val image: String
)

data class GameDetailResponse(
    val id: Int,
    val slug: String,
    val name: String,
    @SerializedName("name_original")
    val nameOriginal: String,
    val description: String,
    val metacritic: Int,
    val released: String?,
    val updated: String,
    @SerializedName("name_original")
    val backgroundImage: String,
    @SerializedName("name_original")
    val backgroundImageAdditional: String,
    val website: String?,
    val rating: Double,
    @SerializedName("name_original")
    val ratingTop: Int,
    val ratings: List<Rating>,
    @SerializedName("name_original")
    val redditUrl: String,
    @SerializedName("name_original")
    val redditName: String,
    @SerializedName("name_original")
    val redditDescription: String,
    @SerializedName("name_original")
    val redditLogo: String,
    @SerializedName("name_original")
    val redditCount: Int,
    @SerializedName("name_original")
    val twitchCount: String,
    @SerializedName("name_original")
    val youtubeCount: String,
    @SerializedName("name_original")
    val reviewsTextCount: Int?,
    @SerializedName("name_original")
    val ratingsCount: Int,
    @SerializedName("name_original")
    val suggestionsCount: Int,
    @SerializedName("name_original")
    val alternativeNames: List<String>,
    @SerializedName("name_original")
    val metacriticUrl: String,
    @SerializedName("name_original")
    val gameSeriesCount: Int,
    @SerializedName("name_original")
    val reviewsCount :Int,
    val platforms: List<GamePlatformResponse>,
    var publishers: List<PublisherResponse> = emptyList(),
    var developers: List<DeveloperResponse> = emptyList(),
    @SerializedName("name_original")
    val descriptionRaw: String?,
    val genres: List<GenreResponse>,
    val clip :String? =null
)

data class Rating(
    val id: Int,
    val title: String,
    val count: Int,
    val percent: Float
)

data class AddedByStatus(
    val yet: Int,
    val owned: Int,
    val beaten: Int,
    val toplay: Int,
    val dropped: Int,
    val playing: Int
)

data class GamePersonResponse(
    val id: Int,
    val name: String,
    val slug: String,
    val imageURL: String,
    val imageBackground: String,
    val gameCount: Int
)

/**
 * @property boolean (Hidden) Default: false Set image as hidden or visible.
 */
data class ScreenShotResponse(
    val id: Int,
    val image: String,
    val hidden: Boolean,
    val width: Int,
    val height: Int
)

/**
 * Get links to the stores that sell the game.
 */
data class GameStoreFullResponse(
    val id: Int,
    val gameID: Int,
    val storeID: Int,
    val url: String
) {

}

/**
 * Get a list of game achievements.
 */
data class AchievementResponse(
    val id: Int,
    val name: String,
    val description: String,
    val imageURL: String,
    val percent: String
)

/**
 * Get a list of most recent posts from the game's subreddit.
 */
data class RecentPostResponse(
    val id: Int,
    val name: String,
    val text: String,
    val imageURL: String,
    val URL: String,
    val username: String,
    val usernameURL: String,
    val created: String
)

/**
 * Get streams on Twitch associated with the game
 */
data class TwitchStreamResponse(
    val id: Int,
    val externalID: Int,
    val name: String,
    val description: String,
    val created: String,
    val published: String,
    val thumbnailURL: String,
    val viewCount: Int,
    val language: String
)

/**
 * Get videos from YouTube associated with the game.
 *
 * channel_id
 */
data class YoutubeChannelResponse(
    val id: Int,
    val externalID: String,
    val channelID: String,
    val channelTitle: String,
    val name: String,
    val description: String,
    val created: String,
    val viewCount: Int,
    val commentCount: Int,
    val likeCount: Int,
    val dislikeCount: Int,
    val favoriteCount: Int,
    val thumbnails: Objects
)
