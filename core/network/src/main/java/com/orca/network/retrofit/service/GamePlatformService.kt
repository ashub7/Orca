package com.orca.network.retrofit.service

import com.orca.network.model.base.PagedResponse
import com.orca.network.model.PlatformParentSingleResponse
import com.orca.network.model.PlatformResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


interface GamePlatformService {
    /**
     * Get a list of video game platforms.
     */
    @GET("/platforms")
    suspend fun getListOfGamePlatforms(
        @Query("ordering") ordering: String? = null,
        @Query("page") page: Int? = null,
        @Query("page_size") pageSize: Int? = null
    ): Response<PagedResponse<PlatformResponse>>

    /**
     * Get a list of parent platforms.
     * For instance, for PS2 and PS4 the “parent platform” is PlayStation.
     */
    @GET("/platforms/lists/parents")
    suspend fun getListOfParentPlatforms(
        @Query("ordering") ordering: String? = null,
        @Query("page") page: Int? = null,
        @Query("page_size") pageSize: Int? = null
    ): Response<PagedResponse<PlatformParentSingleResponse>>

    /**
     * Get details of the platform.
     */
    @GET("/platforms/{id}")
    suspend fun fetchPlatformDetails(
        @Path("id") id: Int
    ): Response<PlatformResponse>

}
