package com.orca.domain.repository

import com.orca.network.model.base.ApiResult
import com.orca.network.model.AchievementResponse
import com.orca.network.model.GameDetailResponse
import com.orca.network.model.GamePersonResponse
import com.orca.network.model.GameResponse
import com.orca.network.model.RecentPostResponse
import com.orca.network.model.ScreenShotResponse
import com.orca.network.model.TwitchStreamResponse
import com.orca.network.model.YoutubeChannelResponse
import com.orca.network.model.base.PagedResponse

interface GameRemoteRepository {

    suspend fun getListOfGames(map: Map<String,String>): ApiResult<PagedResponse<GameResponse>>

    suspend fun getDLC(gamePK:String ,page: Int): ApiResult<PagedResponse<GameResponse>>

    suspend fun getListOfIndividualCreators(gamePK:String, ordering:String, page: Int): ApiResult<PagedResponse<GamePersonResponse>>

    suspend fun getListOfGamesIsPartOfSameSeries(gamePK:String ,page: Int): ApiResult<PagedResponse<GameResponse>>

    suspend fun getListOfParentGamesDLC(gamePK:String ,page: Int): ApiResult<PagedResponse<GameResponse>>

    suspend fun getScreenshotsOfTheGame(gamePK:String, ordering:String): ApiResult<PagedResponse<ScreenShotResponse>>

    suspend fun getDetailsOfGame(id: String): ApiResult<GameDetailResponse>

    suspend fun getListOfGameAchievements(id: String): ApiResult<List<AchievementResponse>>

    suspend fun getGameTrailers(id: String): ApiResult<PagedResponse<Any>>

    suspend fun getListOfMostRecentPostFromGamesSubreddit(id: String): ApiResult<PagedResponse<RecentPostResponse>>

    suspend fun getListOfVisualSimilarGames(id: String): ApiResult<PagedResponse<GameDetailResponse>>

    suspend fun getTwitchStreams(id: String): ApiResult<PagedResponse<TwitchStreamResponse>>

    suspend fun getYoutubeChannel(id: String): ApiResult<PagedResponse<YoutubeChannelResponse>>

}