package com.hana897trx.eclipseanime.ui.screens.home

import com.hana897trx.eclipseanime.data.remote.models.LatestM

sealed class LatestAnimeEvent {
   data class Success(val data: List<LatestM>) : LatestAnimeEvent()
   object Loading : LatestAnimeEvent()
   data class Error(val error: String) : LatestAnimeEvent()
}