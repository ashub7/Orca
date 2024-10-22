package com.orca.data.repo

import com.orca.domain.repository.GamePlatformRemoteRepository
import com.orca.network.datasource.GamePlatformRemoteDataSource
import com.orca.network.model.PlatformParentSingleResponse
import com.orca.network.model.PlatformResponse
import com.orca.network.model.base.ApiResult
import com.orca.network.model.base.PagedResponse
import javax.inject.Inject

class GamePlatformRemoteRepositoryImpl @Inject constructor(
    private val gamePlatformRemoteDataSource: GamePlatformRemoteDataSource
) : GamePlatformRemoteRepository {
    override suspend fun getListOfGamePlatforms(
        ordering: String,
        page: Int
    ): ApiResult<PagedResponse<PlatformResponse>> {
        return gamePlatformRemoteDataSource.getListOfGamePlatforms(ordering = ordering, page = page)
    }

    override suspend fun getListOfParentPlatforms(
        ordering: String,
        page: Int
    ): ApiResult<PagedResponse<PlatformParentSingleResponse>> {
        return gamePlatformRemoteDataSource.getListOfParentPlatforms(
            ordering = ordering,
            page = page
        )
    }

    override suspend fun fetchPlatformDetails(id: Int): ApiResult<PlatformResponse> {
        return gamePlatformRemoteDataSource.fetchPlatformDetails(id = id)
    }

}