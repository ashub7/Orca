package com.orca.network.retrofit.service

import com.orca.network.model.GenreResponse
import com.orca.network.model.base.PagedResponse
import com.orca.network.model.TagResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface GameCategoryService {
    /**
     * Get a list of tags.
     */
    @GET("/tags")
    suspend fun getListOfTags(
        @Query("page") page: Int? = null,
        @Query("page_size") pageSize: Int? = null
    ): Response<PagedResponse<TagResponse>>

    /**
     * Get details of the tag.
     */
    @GET("/tags/{id}")
    suspend fun fetchTagDetails(
        @Path("id") id: Int
    ): Response<TagResponse>

    /**
     * Get a list of video game genres.
     */
    @GET("/genres")
    suspend fun getListOfGamesGenres(
        @Query("ordering") ordering: String? = null,
        @Query("page") page: Int? = null,
        @Query("page_size") pageSize: Int? = null
    ): Response<PagedResponse<GenreResponse>>

    /**
     * Get details of the genre.
     */
    @GET("/genres/{id}")
    suspend fun fetchGenreDetails(
        @Path("id") id: Int
    ): Response<GenreResponse>
}