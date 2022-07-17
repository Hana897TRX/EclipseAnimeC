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
): ViewModel() {
   private var _latestAnimeEvent: MutableStateFlow<LatestAnimeEvent> =
      MutableStateFlow(LatestAnimeEvent.Loading)
   val latestAnimeEvent: StateFlow<LatestAnimeEvent> = _latestAnimeEvent

   init {
      getLatest()
   }

   private fun getLatest() {
      latestAnimeUseCase.invoke().onEach { response ->
         when(response) {
            is DataSource.Loading -> { _latestAnimeEvent.emit(LatestAnimeEvent.Loading) }
            is DataSource.Error -> { _latestAnimeEvent.emit(LatestAnimeEvent.Error(response.message)) }
            is DataSource.Success -> { _latestAnimeEvent.emit(LatestAnimeEvent.Success(response.data)) }
         }
      }.launchIn(viewModelScope)
   }
}