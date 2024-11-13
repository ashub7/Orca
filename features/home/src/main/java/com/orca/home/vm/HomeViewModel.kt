package com.orca.home.vm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.orca.domain.usecases.game.GetHomeScreenDataUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getHomeScreenDataUseCase: GetHomeScreenDataUseCase
) : ViewModel() {

}