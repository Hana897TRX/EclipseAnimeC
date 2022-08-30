package com.hana897trx.eclipseanime.ui.screens.home.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hana897trx.eclipseanime.data.remote.models.LatestM
import com.hana897trx.eclipseanime.domain.LatestAnimeUseCase
import com.hana897trx.eclipseanime.domain.SaveSelectedAnime
import com.hana897trx.eclipseanime.ui.screens.home.events.LatestAnimeEvent
import com.hana897trx.eclipseanime.ui.screens.home.events.SaveSelectedAnimeEvent
import com.hana897trx.eclipseanime.utils.DataSource
import com.hana897trx.eclipseanime.utils.mapResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val latestAnimeUseCase: LatestAnimeUseCase,
    private val saveSelectedAnime: SaveSelectedAnime
) : ViewModel() {

    private val TAG = "HOME_LATEST"
    private var _animeEvent: MutableStateFlow<LatestAnimeEvent> =
        MutableStateFlow(LatestAnimeEvent.Loading)
    val animeEvent: StateFlow<LatestAnimeEvent> = _animeEvent

    private var _saveSelectedAnime: MutableStateFlow<SaveSelectedAnimeEvent> =
        MutableStateFlow(SaveSelectedAnimeEvent.Loading)
    val saveSelectedAnimeEvent: StateFlow<SaveSelectedAnimeEvent> = _saveSelectedAnime

    init {
        getLatest()
    }

    fun saveSelectedAnime(latestM: LatestM) {
        saveSelectedAnime.invoke(latestM).onEach { response ->
            response.mapResponse(
                successState = { _saveSelectedAnime.emit(SaveSelectedAnimeEvent.Success(it.data)) },
                loadingState = { _saveSelectedAnime.emit(SaveSelectedAnimeEvent.Loading) },
                errorState = { _saveSelectedAnime.emit(SaveSelectedAnimeEvent.Error(it.message, it.errorCode)) }
            )
        }.launchIn(viewModelScope)
    }

    private fun getLatest() = latestAnimeUseCase.invoke().onEach { response ->
        response.mapResponse(
            successState = { _animeEvent.emit(LatestAnimeEvent.Success(it.data)) },
            loadingState = { _animeEvent.emit(LatestAnimeEvent.Loading) },
            errorState = { _animeEvent.emit(LatestAnimeEvent.Error(it.message, it.errorCode)) }
        )
    }.launchIn(viewModelScope)
}