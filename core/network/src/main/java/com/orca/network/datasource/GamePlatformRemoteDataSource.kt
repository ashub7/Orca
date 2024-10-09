package com.orca.network.datasource

import com.orca.network.model.PlatformParentSingleResponse
import com.orca.network.model.PlatformResponse
import com.orca.network.model.base.ApiResult
import com.orca.network.model.base.NetworkConstants
import com.orca.network.model.base.PagedResponse
import com.orca.network.retrofit.handleApi
import com.orca.network.retrofit.service.GamePlatformService
import javax.inject.Inject

interface GamePlatformRemoteDataSource {
    suspend fun getListOfGamePlatforms(
        ordering: String,
        page: Int
    ): ApiResult<PagedResponse<PlatformResponse>>

    suspend fun getListOfParentPlatforms(
        ordering: String,
        page: Int
    ): ApiResult<PagedResponse<PlatformParentSingleResponse>>

    suspend fun fetchPlatformDetails(id: Int): ApiResult<PlatformResponse>

}

class GamePlatformRemoteDataSourceImpl @Inject constructor(
    private val gamePlatformService: GamePlatformService
) : GamePlatformRemoteDataSource {


    override suspend fun getListOfGamePlatforms(
        ordering: String,
        page: Int
    ) =
        handleApi {
            gamePlatformService.getListOfGamePlatforms(
                ordering,
                page,
                NetworkConstants.PAGE_SIZE
            )
        }

    override suspend fun getListOfParentPlatforms(
        ordering: String,
        page: Int
    ) = handleApi {
        gamePlatformService.getListOfParentPlatforms(
            ordering,
            page,
            NetworkConstants.PAGE_SIZE
        )
    }

    override suspend fun fetchPlatformDetails(id: Int) =
        handleApi { gamePlatformService.fetchPlatformDetails(id) }

}