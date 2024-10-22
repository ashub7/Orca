package com.orca.network.di

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
abstract class RemoteDataSourceModule {
    @Binds
    abstract fun bindGameDataSource(gameRemoteDataSourceImpl: GameRemoteDataSourceImpl): GameRemoteDataSource

    @Binds
    abstract fun bindCreatorDataSource(creatorRemoteDataSource: CreatorRemoteDataSourceImpl): CreatorRemoteDataSource

    @Binds
    abstract fun bindGamePlatformDataSource(gamePlatformRemoteDataSource: GamePlatformRemoteDataSourceImpl): GamePlatformRemoteDataSource

    @Binds
    abstract fun bindGameCategoryDataSource(gameCategoryRemoteDataSource: GameCategoryRemoteDataSourceImpl): GameCategoryRemoteDataSource


}