package com.hana897trx.eclipseanime.ui.screens.home

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hana897trx.eclipseanime.domain.LatestAnimeUseCase
import com.hana897trx.eclipseanime.utils.DataSource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val latestAnimeUseCase: LatestAnimeUseCase
) : ViewModel() {

    private val TAG = "HOME_LATEST"

    init {
        getLatest()
    }

    private fun getLatest() = latestAnimeUseCase.invoke().onEach { response ->
        when(response) {
            is DataSource.Loading -> { Log.w(TAG, "Loading") }
            is DataSource.Error -> { Log.w(TAG, "Error") }
            is DataSource.Success -> { Log.w(TAG, "Success") }
        }
    }.launchIn(viewModelScope)
}