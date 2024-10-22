package com.orca.domain.repository

import com.orca.network.model.CreatorResponse
import com.orca.network.model.DeveloperResponse
import com.orca.network.model.GameStoreFullResponse
import com.orca.network.model.JobResponse
import com.orca.network.model.PublisherResponse
import com.orca.network.model.StoreResponse
import com.orca.network.model.base.ApiResult
import com.orca.network.model.base.PagedResponse

interface CreatorRemoteRepository {

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