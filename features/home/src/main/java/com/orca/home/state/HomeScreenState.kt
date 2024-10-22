package com.orca.home.state

import androidx.compose.runtime.Immutable
import com.orca.design.core.PageState
import kotlinx.collections.immutable.ImmutableMap


@Immutable
data class HomeScreenState(
    val pageState: PageState = PageState.INITIAL,
    val errorMessage: String = "",
    val data: ImmutableMap<String, String>
)