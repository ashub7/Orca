package com.orca.data.repo

import com.orca.domain.repository.GameCategoryRemoteRepository
import com.orca.network.datasource.GameCategoryRemoteDataSource
import com.orca.network.model.GenreResponse
import com.orca.network.model.TagResponse
import com.orca.network.model.base.ApiResult
import com.orca.network.model.base.PagedResponse
import javax.inject.Inject

class GameCategoryRemoteRepositoryImpl @Inject constructor(
    private val gameCategoryRemoteDataSource: GameCategoryRemoteDataSource
) : GameCategoryRemoteRepository {
    override suspend fun getListOfGamesGenres(
        ordering: String,
        page: Int
    ): ApiResult<PagedResponse<GenreResponse>> {
        return gameCategoryRemoteDataSource.getListOfGamesGenres(ordering = ordering, page = page)
    }

    override suspend fun fetchGenreDetails(id: Int): ApiResult<GenreResponse> {
        return gameCategoryRemoteDataSource.fetchGenreDetails(id = id)
    }

    override suspend fun getListOfTags(page: Int): ApiResult<PagedResponse<TagResponse>> {
        return gameCategoryRemoteDataSource.getListOfTags(page = page)
    }

    override suspend fun fetchTagsDetails(id: Int): ApiResult<TagResponse> {
        return gameCategoryRemoteDataSource.fetchTagsDetails(id = id)
    }

}