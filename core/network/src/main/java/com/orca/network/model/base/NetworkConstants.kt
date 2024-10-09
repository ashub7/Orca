package com.orca.network.model.base

import java.time.Duration


object NetworkConstants {
    const val BASE_URL = "https://api.rawg.io"
    const val PAGE_SIZE = 20
    const val PAGE_SIZE_MAX = 50
    val TIMEOUT: Duration = Duration.ofSeconds(5L)
}