package com.hana897trx.eclipseanime.ui.screens.home.events

import com.hana897trx.eclipseanime.utils.DefaultValues
import com.hana897trx.eclipseanime.utils.ErrorCodes

sealed class SaveSelectedAnimeEvent {
    object Loading: SaveSelectedAnimeEvent()
    data class Error(val message: String = DefaultValues.EMPTY, val errorCode: ErrorCodes) : SaveSelectedAnimeEvent()
    data class Success(val data: Long) : SaveSelectedAnimeEvent()
}