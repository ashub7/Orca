package com.orca.network.di

import com.google.gson.GsonBuilder
import com.orca.network.model.base.NetworkConstants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.time.Duration
import javax.inject.Named
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun providesOkHttpClient(
        @Named("auth") authInterceptor: Interceptor,
    ): OkHttpClient {
        return OkHttpClient.Builder().addInterceptor(authInterceptor)
            .connectTimeout(NetworkConstants.TIMEOUT)
            .readTimeout(NetworkConstants.TIMEOUT)
            .addInterceptor(HttpLoggingInterceptor().apply {
                setLevel(HttpLoggingInterceptor.Level.BASIC)
            })
            .writeTimeout(NetworkConstants.TIMEOUT)
            .build()
    }

    @Provides
    @Singleton
    @Named("auth")
    fun providesAuthInterceptor(): Interceptor {
        return Interceptor {
            val newRequest = it.request()
                .newBuilder()
                .url(
                    it.request().url.newBuilder()
                        .addQueryParameter("api_key", "BuildConfig.API_KEY")
                        .build()
                ).build()
            it.proceed(newRequest)
        }
    }

    @Provides
    @Singleton
    fun providesRetrofitClient(
        okHttpClient: OkHttpClient,
        gsonConverterFactory: GsonConverterFactory
    ): Retrofit {
        return Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl(NetworkConstants.BASE_URL)
            .addConverterFactory(
                gsonConverterFactory
            )
            .build()
    }

    @Singleton
    @Provides
    fun providesGsonConverterFactory(): GsonConverterFactory {
        val gsonBuilder = GsonBuilder()
        return GsonConverterFactory.create(gsonBuilder.create())
    }

}