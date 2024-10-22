package com.orca.network.model


data class AssetDataResponse(
    var genreList: List<GenreResponse>,
    var platforms: List<PlatformResponse>,
    var parentPlatforms: List<PlatformParentSingleResponse>
)
