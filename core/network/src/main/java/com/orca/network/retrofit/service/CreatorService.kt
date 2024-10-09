package com.orca.network.retrofit.service

import com.orca.network.model.CreatorResponse
import com.orca.network.model.DeveloperResponse
import com.orca.network.model.GameStoreFullResponse
import com.orca.network.model.JobResponse
import com.orca.network.model.base.PagedResponse
import com.orca.network.model.PublisherResponse
import com.orca.network.model.StoreResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


interface CreatorService {
    /**
     * Get a list of creator positions (jobs).
     */
    @GET("/creator-roles")
    suspend fun getListOfCreatorPosition(
        @Query("page") page: Int? = null,
        @Query("page_size") pageSize: Int? = null
    ): Response<PagedResponse<JobResponse>>

    /**
     * Get a list of game creators.
     */
    @GET("/creators")
    suspend fun getListOfGameCreators(
        @Query("page") page: Int? = null,
        @Query("page_size") pageSize: Int? = null
    ): Response<PagedResponse<CreatorResponse>>

    /**
     * Get details of the creator.
     */
    @GET("/creators/{id}")
    suspend fun fetchCreatorDetails(
        @Path("id") id: String
    ): Response<CreatorResponse>

    /**
     * Get a list of game developers.
     */
    @GET("/developers")
    suspend fun getDevelopersList(
        @Query("page") page: Int,
        @Query("page_size") pageSize: Int
    ): Response<PagedResponse<DeveloperResponse>>

    /**
     * Get details of the developer.
     */
    @GET("/developers/{id}")
    suspend fun fetchDeveloperDetails(
        @Path("id") id: String
    ): Response<DeveloperResponse>

    /**
     * Get a list of video game publishers.
     */
    @GET("/publishers")
    suspend fun getListOfVideoGamesPublishers(
        @Query("page") page: Int? = null,
        @Query("page_size") pageSize: Int? = null
    ): Response<PagedResponse<PublisherResponse>>

    /**
     *Get details of the publisher.
     */
    @GET("/publishers/{id}")
    suspend fun fetchPublisherDetails(
        @Path("id") id: Int
    ): Response<PublisherResponse>

    /**
     * Get a list of video game storefronts.
     */
    @GET("/stores")
    suspend fun getListOfGameStoreFronts(
        @Query("ordering") ordering: String? = null,
        @Query("page") page: Int? = null,
        @Query("page_size") pageSize: Int? = null
    ): Response<PagedResponse<StoreResponse>>

    /**
     * Get details of the store.
     */
    @GET("/stores/{id}")
    suspend fun fetchStoreDetails(
        @Path("id") id: Int
    ): Response<StoreResponse>

    /**
     * Get links to the stores that sell the game.
     */
    @GET("api/games/{game_id}/stores")
    suspend fun getLinksToStoresThatSellTheGame(
        @Path("game_id") gamePK: String,
        @Query("ordering") ordering: String? = null,
        @Query("page") page: Int? = null,
        @Query("page_size") pageSize: Int? = null
    ): Response<PagedResponse<GameStoreFullResponse>>

}
