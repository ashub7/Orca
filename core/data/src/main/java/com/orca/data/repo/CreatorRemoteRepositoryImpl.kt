package com.orca.data.repo

import com.orca.domain.repository.CreatorRemoteRepository
import com.orca.network.datasource.CreatorRemoteDataSource
import com.orca.network.model.CreatorResponse
import com.orca.network.model.DeveloperResponse
import com.orca.network.model.GameStoreFullResponse
import com.orca.network.model.JobResponse
import com.orca.network.model.PublisherResponse
import com.orca.network.model.StoreResponse
import com.orca.network.model.base.ApiResult
import com.orca.network.model.base.PagedResponse
import javax.inject.Inject

class CreatorRemoteRepositoryImpl @Inject constructor(
    private val creatorRemoteDataSource: CreatorRemoteDataSource
) : CreatorRemoteRepository {
    override suspend fun getListOfCreatorPosition(page: Int): ApiResult<PagedResponse<JobResponse>> {
        return creatorRemoteDataSource.getListOfCreatorPosition(page = page)
    }

    override suspend fun getListOfGameCreators(page: Int): ApiResult<PagedResponse<CreatorResponse>> {
        return creatorRemoteDataSource.getListOfGameCreators(page = page)
    }

    override suspend fun fetchCreatorDetails(id: String): ApiResult<CreatorResponse> {
        return creatorRemoteDataSource.fetchCreatorDetails(id = id)
    }

    override suspend fun getDevelopersList(page: Int): ApiResult<PagedResponse<DeveloperResponse>> {
        return creatorRemoteDataSource.getDevelopersList(page = page)
    }

    override suspend fun fetchDeveloperDetails(id: String): ApiResult<DeveloperResponse> {
        return creatorRemoteDataSource.fetchDeveloperDetails(id = id)
    }

    override suspend fun getListOfVideoGamesPublishers(page: Int): ApiResult<PagedResponse<PublisherResponse>> {
        return creatorRemoteDataSource.getListOfVideoGamesPublishers(page = page)
    }

    override suspend fun fetchPublisherDetails(id: Int): ApiResult<PublisherResponse> {
        return creatorRemoteDataSource.fetchPublisherDetails(id = id)
    }

    override suspend fun getListOfGameStoreFronts(
        ordering: String,
        page: Int
    ): ApiResult<PagedResponse<StoreResponse>> {
        return creatorRemoteDataSource.getListOfGameStoreFronts(ordering = ordering, page = page)
    }

    override suspend fun fetchStoreDetails(id: Int): ApiResult<StoreResponse> {
        return creatorRemoteDataSource.fetchStoreDetails(id = id)
    }

    override suspend fun getLinksToStoresThatSellTheGame(
        gamePK: String,
        ordering: String
    ): ApiResult<PagedResponse<GameStoreFullResponse>> {
        return creatorRemoteDataSource.getLinksToStoresThatSellTheGame(gamePK = gamePK, ordering = ordering)
    }

}