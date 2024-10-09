package com.orca.network.di

import com.orca.network.datasource.FoodRemoteDataSource
import com.orca.network.datasource.FoodRemoteDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RemoteDataSourceModule {
    @Binds
    abstract fun bindFoodDataSource(foodRemoteDataSourceImpl: FoodRemoteDataSourceImpl): FoodRemoteDataSource
}