package com.orca.network.datasource

import com.orca.network.model.GenreResponse
import com.orca.network.model.TagResponse
import com.orca.network.model.base.ApiResult
import com.orca.network.model.base.NetworkConstants
import com.orca.network.model.base.PagedResponse
import com.orca.network.retrofit.handleApi
import com.orca.network.retrofit.service.GameCategoryService
import javax.inject.Inject

interface GameCategoryRemoteDataSource {

    suspend fun getListOfGamesGenres(ordering:String, page: Int): ApiResult<PagedResponse<GenreResponse>>

    suspend fun fetchGenreDetails(id: Int): ApiResult<GenreResponse>

    suspend fun getListOfTags(page: Int): ApiResult<PagedResponse<TagResponse>>

    suspend fun fetchTagsDetails(id: Int): ApiResult<TagResponse>
}

class GameCategoryRemoteDataSourceImpl @Inject constructor(
    private val gameCategoryService : GameCategoryService
) : GameCategoryRemoteDataSource {

    override suspend fun getListOfGamesGenres(
        ordering: String,
        page: Int
    ) = handleApi { gameCategoryService.getListOfGamesGenres(ordering, page, NetworkConstants.PAGE_SIZE) }

    override suspend fun fetchGenreDetails(id: Int) =
        handleApi { gameCategoryService.fetchGenreDetails(id) }


    override suspend fun getListOfTags(page: Int) =
        handleApi { gameCategoryService.getListOfTags(page, NetworkConstants.PAGE_SIZE) }

    override suspend fun fetchTagsDetails(id: Int) =
        handleApi { gameCategoryService.fetchTagDetails(id) }
}