package com.orca.home.state

import androidx.annotation.StringRes
import com.orca.home.R
import com.orca.models.request.GameRequestBuilder


enum class HomePageRequest(
    val type: Int,
    val requestParams: Map<String, String>,
    @StringRes val title: Int
) {
    POPULAR(1, GameRequestBuilder.homePopular(), R.string.popular),
    LATEST(2, GameRequestBuilder.latestRelease(1), R.string.latest_releases),
    UPCOMING(3, GameRequestBuilder.upcoming(1), R.string.upcoming),
}