package com.orca.domain.repository

import com.orca.network.model.PlatformParentSingleResponse
import com.orca.network.model.PlatformResponse
import com.orca.network.model.base.ApiResult
import com.orca.network.model.base.PagedResponse

interface GamePlatformRemoteRepository {
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
