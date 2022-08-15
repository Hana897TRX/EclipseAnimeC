package com.hana897trx.eclipseanime.ui.screens.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hana897trx.eclipseanime.domain.LatestAnimeUseCase
import com.hana897trx.eclipseanime.utils.DataSource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val latestAnimeUseCase: LatestAnimeUseCase
) : ViewModel() {

    private val TAG = "HOME_LATEST"
    private var _animeEvent : MutableStateFlow<LatestAnimeEvent> = MutableStateFlow(LatestAnimeEvent.Loading)
    val animeEvent : StateFlow<LatestAnimeEvent> = _animeEvent

    init {
        getLatest()
    }

    private fun getLatest() = latestAnimeUseCase.invoke().onEach { response ->
        when(response) {
            is DataSource.Loading -> { _animeEvent.emit(LatestAnimeEvent.Loading) }
            is DataSource.Error -> {  _animeEvent.emit(LatestAnimeEvent.Error(response.message, response.errorCode)) }
            is DataSource.Success -> {  _animeEvent.emit(LatestAnimeEvent.Success(response.data)) }
        }
    }.launchIn(viewModelScope)
}