package com.orca.network.di

import com.orca.network.retrofit.service.CreatorService
import com.orca.network.retrofit.service.GameCategoryService
import com.orca.network.retrofit.service.GamePlatformService
import com.orca.network.retrofit.service.GameService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit

@Module
@InstallIn(SingletonComponent::class)
object ServiceModule {

    @Provides
    fun provideGameService(retrofit: Retrofit): GameService {
        return retrofit.create(GameService::class.java)
    }

    @Provides
    fun provideGameCategoryService(retrofit: Retrofit): GameCategoryService {
        return retrofit.create(GameCategoryService::class.java)
    }

    @Provides
    fun provideGamePlatformService(retrofit: Retrofit): GamePlatformService {
        return retrofit.create(GamePlatformService::class.java)
    }

    @Provides
    fun provideCreatorService(retrofit: Retrofit): CreatorService {
        return retrofit.create(CreatorService::class.java)
    }
}