package com.orca.database.di

import com.orca.database.repo.DataStoreRepository
import com.orca.database.repo.DataStoreRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class PreferenceModule {
   /* @Provides
    fun provideDataStore(@ApplicationContext context: Context): DataStore<Preferences> {
        return context.prefDataStore
    }*/
    @Binds
   abstract fun bindPreferenceRepository(preferenceRepositoryImpl: DataStoreRepositoryImpl): DataStoreRepository
}