package com.orca.network.model

import com.ace.blaze.data.model.Platform
import com.ace.blaze.data.model.PlatformParentSingle

data class AssetDataResponse(
    var genreList: List<Genre>,
    var platforms: List<Platform>,
    var parentPlatforms: List<PlatformParentSingle>
)
