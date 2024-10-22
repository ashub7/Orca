package com.orca.domain.repository

import com.orca.network.model.GenreResponse
import com.orca.network.model.TagResponse
import com.orca.network.model.base.ApiResult
import com.orca.network.model.base.PagedResponse

interface GameCategoryRemoteRepository {

    suspend fun getListOfGamesGenres(ordering:String, page: Int): ApiResult<PagedResponse<GenreResponse>>

    suspend fun fetchGenreDetails(id: Int): ApiResult<GenreResponse>

    suspend fun getListOfTags(page: Int): ApiResult<PagedResponse<TagResponse>>

    suspend fun fetchTagsDetails(id: Int): ApiResult<TagResponse>
}