package com.orca.network.datasource

import com.orca.network.model.base.ApiFailure
import com.orca.network.retrofit.service.CreatorService
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.runTest
import okhttp3.OkHttpClient
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class CreatorRemoteDataSourceTest {
    private lateinit var subject: CreatorRemoteDataSource
    private lateinit var creatorService: CreatorService
    private val mockWebServer = MockWebServer()
    private val testDispatcher = StandardTestDispatcher()

    @Before
    fun setUp() {
        creatorService = Retrofit.Builder()
            .baseUrl(mockWebServer.url("/"))
            .client(OkHttpClient.Builder().build())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CreatorService::class.java)

        subject = CreatorRemoteDataSourceImpl(
            creatorService = creatorService
        )
    }

    @Test
    fun `getListOfGameCreators Error Case`() = runTest(testDispatcher) {
        mockWebServer.enqueue(
            MockResponse()
                .setResponseCode(400).setBody("Error")
        )
        val response = subject.getListOfGameCreators(1)
        Assert.assertTrue(response is ApiFailure)
    }
}