package com.orca.network.datasource

import com.orca.network.model.base.ApiResult
import com.orca.network.model.AchievementResponse
import com.orca.network.model.CreatorResponse
import com.orca.network.model.DeveloperResponse
import com.orca.network.model.GameDetailResponse
import com.orca.network.model.GamePersonResponse
import com.orca.network.model.GameResponse
import com.orca.network.model.GameStoreFullResponse
import com.orca.network.model.GenreResponse
import com.orca.network.model.JobResponse
import com.orca.network.model.PlatformParentSingleResponse
import com.orca.network.model.PlatformResponse
import com.orca.network.model.PublisherResponse
import com.orca.network.model.RecentPostResponse
import com.orca.network.model.ScreenShotResponse
import com.orca.network.model.StoreResponse
import com.orca.network.model.TagResponse
import com.orca.network.model.TwitchStreamResponse
import com.orca.network.model.YoutubeChannelResponse
import com.orca.network.model.base.NetworkConstants
import com.orca.network.model.base.PagedResponse
import com.orca.network.retrofit.handleApi
import com.orca.network.retrofit.service.GameService
import javax.inject.Inject

interface GameRemoteDataSource {

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

class GameRemoteDataSourceImpl @Inject constructor(
    private val gameService: GameService
) : GameRemoteDataSource {

    override suspend fun getListOfGames(map: Map<String, String>) =
        handleApi { gameService.getListOfGames(map) }

    override suspend fun getDLC(gamePK: String, page: Int) =
        handleApi { gameService.getDLC(gamePK, page = page, pageSize = NetworkConstants.PAGE_SIZE) }

    override suspend fun getListOfIndividualCreators(
        gamePK: String,
        ordering: String,
        page: Int
    ) = handleApi {
        gameService.getListOfIndividualCreators(
            gamePK = gamePK,
            ordering = ordering,
            page = page,
            pageSize = NetworkConstants.PAGE_SIZE
        )
    }


    override suspend fun getListOfGamesIsPartOfSameSeries(
        gamePK: String,
        page: Int
    ) = handleApi {
        gameService.getListOfGamesIsPartOfSameSeries(
            gamePK,
            page,
            NetworkConstants.PAGE_SIZE
        )
    }

    override suspend fun getListOfParentGamesDLC(
        gamePK: String,
        page: Int
    ) = handleApi { gameService.getListOfParentGamesDLC(gamePK, page, NetworkConstants.PAGE_SIZE) }

    override suspend fun getScreenshotsOfTheGame(
        gamePK: String,
        ordering: String,
    ) =
        handleApi {
            gameService.getScreenshotsOfTheGame(
                gamePK,
                ordering,
                1,
                NetworkConstants.PAGE_SIZE_MAX
            )
        }

    override suspend fun getDetailsOfGame(id: String) =
        handleApi { gameService.getDetailsOfGame(id) }

    override suspend fun getListOfGameAchievements(id: String) =
        handleApi { gameService.getListOfGameAchievements(id) }

    override suspend fun getGameTrailers(id: String) =
        handleApi { gameService.getGameTrailers(id) }

    override suspend fun getListOfMostRecentPostFromGamesSubreddit(id: String) =
        handleApi { gameService.getListOfMostRecentPostFromGamesSubreddit(id) }

    override suspend fun getListOfVisualSimilarGames(id: String) =
        handleApi { gameService.getListOfVisualSimilarGames(id) }

    override suspend fun getTwitchStreams(id: String) =
        handleApi { gameService.getTwitchStreams(id) }

    override suspend fun getYoutubeChannel(id: String) =
        handleApi { gameService.getYoutubeChannel(id) }
}