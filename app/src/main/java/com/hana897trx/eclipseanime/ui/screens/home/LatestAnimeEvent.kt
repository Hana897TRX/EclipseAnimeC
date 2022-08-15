package com.hana897trx.eclipseanime.ui.screens.home

import com.hana897trx.eclipseanime.data.remote.models.LatestM
import com.hana897trx.eclipseanime.utils.DefaultValues
import com.hana897trx.eclipseanime.utils.ErrorCodes

sealed class LatestAnimeEvent {
    object Loading: LatestAnimeEvent()
    data class Error(val message: String = DefaultValues.EMPTY, val errorCode: ErrorCodes) : LatestAnimeEvent()
    data class Success(val data: List<LatestM>) : LatestAnimeEvent()
}