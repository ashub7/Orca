package com.orca.data.di

import com.orca.data.repo.CreatorRemoteRepositoryImpl
import com.orca.data.repo.GameCategoryRemoteRepositoryImpl
import com.orca.data.repo.GamePlatformRemoteRepositoryImpl
import com.orca.data.repo.GameRemoteRepositoryImpl
import com.orca.domain.repository.CreatorRemoteRepository
import com.orca.domain.repository.GameCategoryRemoteRepository
import com.orca.domain.repository.GamePlatformRemoteRepository
import com.orca.domain.repository.GameRemoteRepository
import com.orca.network.datasource.CreatorRemoteDataSource
import com.orca.network.datasource.CreatorRemoteDataSourceImpl
import com.orca.network.datasource.GameCategoryRemoteDataSource
import com.orca.network.datasource.GameCategoryRemoteDataSourceImpl
import com.orca.network.datasource.GamePlatformRemoteDataSource
import com.orca.network.datasource.GamePlatformRemoteDataSourceImpl
import com.orca.network.datasource.GameRemoteDataSource
import com.orca.network.datasource.GameRemoteDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RemoteRepositoryModule {
    @Binds
    abstract fun bindGameRemoteRepository(gameRemoteRepositoryImpl: GameRemoteRepositoryImpl): GameRemoteRepository

    @Binds
    abstract fun bindCreatorRemoteRepository(creatorRemoteRepositoryImpl: CreatorRemoteRepositoryImpl): CreatorRemoteRepository

    @Binds
    abstract fun bindGamePlatformRemoteRepository(gamePlatformRemoteRepositoryImpl: GamePlatformRemoteRepositoryImpl): GamePlatformRemoteRepository

    @Binds
    abstract fun bindGameCategoryRemoteRepository(gameCategoryRemoteRepository: GameCategoryRemoteRepositoryImpl): GameCategoryRemoteRepository


}