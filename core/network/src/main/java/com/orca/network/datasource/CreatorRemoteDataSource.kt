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
import com.orca.network.retrofit.service.CreatorService
import com.orca.network.retrofit.service.GameService
import javax.inject.Inject

interface CreatorRemoteDataSource {
    suspend fun getListOfCreatorPosition(page: Int): ApiResult<PagedResponse<JobResponse>>

    suspend fun getListOfGameCreators(page: Int): ApiResult<PagedResponse<CreatorResponse>>

    suspend fun fetchCreatorDetails(id: String): ApiResult<CreatorResponse>

    suspend fun getDevelopersList(page: Int): ApiResult<PagedResponse<DeveloperResponse>>

    suspend fun fetchDeveloperDetails(id: String): ApiResult<DeveloperResponse>

    suspend fun getListOfVideoGamesPublishers(page: Int): ApiResult<PagedResponse<PublisherResponse>>

    suspend fun fetchPublisherDetails(id: Int): ApiResult<PublisherResponse>

    suspend fun getListOfGameStoreFronts(
        ordering: String,
        page: Int
    ): ApiResult<PagedResponse<StoreResponse>>

    suspend fun fetchStoreDetails(id: Int): ApiResult<StoreResponse>

    suspend fun getLinksToStoresThatSellTheGame(
        gamePK: String,
        ordering: String
    ): ApiResult<PagedResponse<GameStoreFullResponse>>

}

class CreatorRemoteDataSourceImpl @Inject constructor(
    private val creatorService: CreatorService
) : CreatorRemoteDataSource {

    override suspend fun getListOfCreatorPosition(page: Int) =
        handleApi { creatorService.getListOfCreatorPosition(page, NetworkConstants.PAGE_SIZE) }

    override suspend fun getListOfGameCreators(page: Int) =
        handleApi { creatorService.getListOfGameCreators(page) }

    override suspend fun fetchCreatorDetails(id: String) =
        handleApi { creatorService.fetchCreatorDetails(id) }

    override suspend fun getDevelopersList(page: Int) =
        handleApi { creatorService.getDevelopersList(page, NetworkConstants.PAGE_SIZE) }


    override suspend fun fetchDeveloperDetails(id: String) =
        handleApi { creatorService.fetchDeveloperDetails(id) }

    override suspend fun getLinksToStoresThatSellTheGame(
        gamePK: String,
        ordering: String // Ordering.RATING_REVERSE.type
    ) =
        handleApi {
            creatorService.getLinksToStoresThatSellTheGame(
                gamePK,
                ordering,
                1,
                NetworkConstants.PAGE_SIZE_MAX
            )
        }

    override suspend fun getListOfVideoGamesPublishers(page: Int) =
        handleApi { creatorService.getListOfVideoGamesPublishers(page, NetworkConstants.PAGE_SIZE) }

    override suspend fun fetchPublisherDetails(id: Int) =
        handleApi { creatorService.fetchPublisherDetails(id) }

    override suspend fun getListOfGameStoreFronts(
        ordering: String,
        page: Int
    ) = handleApi {
        creatorService.getListOfGameStoreFronts(
            ordering,
            page,
            NetworkConstants.PAGE_SIZE
        )
    }

    override suspend fun fetchStoreDetails(id: Int) =
        handleApi { creatorService.fetchStoreDetails(id) }

}