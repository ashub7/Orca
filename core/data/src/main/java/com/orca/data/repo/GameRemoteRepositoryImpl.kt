package com.orca.data.repo

import com.orca.domain.repository.GameRemoteRepository
import com.orca.network.datasource.GameRemoteDataSource
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
import javax.inject.Inject

class GameRemoteRepositoryImpl @Inject constructor(
    private val gameRemoteDataSource: GameRemoteDataSource
) : GameRemoteRepository {
    override suspend fun getListOfGames(map: Map<String, String>): ApiResult<PagedResponse<GameResponse>> {
        return gameRemoteDataSource.getListOfGames(map = map)
    }

    override suspend fun getDLC(gamePK: String, page: Int): ApiResult<PagedResponse<GameResponse>> {
        return gameRemoteDataSource.getDLC(gamePK = gamePK, page = page)
    }

    override suspend fun getListOfIndividualCreators(
        gamePK: String,
        ordering: String,
        page: Int
    ): ApiResult<PagedResponse<GamePersonResponse>> {
        return gameRemoteDataSource.getListOfIndividualCreators(
            gamePK = gamePK,
            ordering = ordering,
            page = page
        )
    }

    override suspend fun getListOfGamesIsPartOfSameSeries(
        gamePK: String,
        page: Int
    ): ApiResult<PagedResponse<GameResponse>> {
        return gameRemoteDataSource.getListOfGamesIsPartOfSameSeries(
            gamePK = gamePK,
            page = page
        )
    }

    override suspend fun getListOfParentGamesDLC(
        gamePK: String,
        page: Int
    ): ApiResult<PagedResponse<GameResponse>> {
        return gameRemoteDataSource.getListOfParentGamesDLC(
            gamePK = gamePK,
            page = page
        )
    }

    override suspend fun getScreenshotsOfTheGame(
        gamePK: String,
        ordering: String
    ): ApiResult<PagedResponse<ScreenShotResponse>> {
        return gameRemoteDataSource.getScreenshotsOfTheGame(
            gamePK = gamePK,
            ordering = ordering
        )
    }

    override suspend fun getDetailsOfGame(id: String): ApiResult<GameDetailResponse> {
        return gameRemoteDataSource.getDetailsOfGame(id = id)
    }

    override suspend fun getListOfGameAchievements(id: String): ApiResult<List<AchievementResponse>> {
        return gameRemoteDataSource.getListOfGameAchievements(id = id)
    }

    override suspend fun getGameTrailers(id: String): ApiResult<PagedResponse<Any>> {
        return gameRemoteDataSource.getGameTrailers(id = id)
    }

    override suspend fun getListOfMostRecentPostFromGamesSubreddit(id: String): ApiResult<PagedResponse<RecentPostResponse>> {
        return gameRemoteDataSource.getListOfMostRecentPostFromGamesSubreddit(id = id)
    }

    override suspend fun getListOfVisualSimilarGames(id: String): ApiResult<PagedResponse<GameDetailResponse>> {
        return gameRemoteDataSource.getListOfVisualSimilarGames(id = id)
    }

    override suspend fun getTwitchStreams(id: String): ApiResult<PagedResponse<TwitchStreamResponse>> {
        return gameRemoteDataSource.getTwitchStreams(id = id)
    }

    override suspend fun getYoutubeChannel(id: String): ApiResult<PagedResponse<YoutubeChannelResponse>> {
        return gameRemoteDataSource.getYoutubeChannel(id = id)
    }
}