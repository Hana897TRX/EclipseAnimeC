package com.hana897trx.eclipseanime.ui.screens.details

import androidx.lifecycle.ViewModel
import com.hana897trx.eclipseanime.domain.GetSelectedAnime
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor(
    private val getSelectedAnime: GetSelectedAnime
): ViewModel() {

}