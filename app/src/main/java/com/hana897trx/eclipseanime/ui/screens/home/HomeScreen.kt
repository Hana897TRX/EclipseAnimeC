package com.hana897trx.eclipseanime.ui.screens.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.hana897trx.eclipseanime.R
import com.hana897trx.eclipseanime.ui.components.PopularContent
import com.hana897trx.eclipseanime.ui.components.PromiseContent
import com.hana897trx.eclipseanime.ui.screens.home.events.LatestAnimeEvent
import com.hana897trx.eclipseanime.ui.screens.home.events.SaveSelectedAnimeEvent
import com.hana897trx.eclipseanime.ui.screens.home.viewModel.HomeViewModel
import com.hana897trx.eclipseanime.ui.theme.EclipseAnimeCTheme
import com.hana897trx.eclipseanime.utils.DataSource
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

@Composable
fun HomeScreen(
    homeViewModel: HomeViewModel = viewModel(),
    animeCardClick : () -> Unit
) {
    Column(modifier = Modifier.fillMaxSize()) {
        LazyColumn {
            item {
                PopularContent()
            }
            item {
                NewChaptersData(homeViewModel) {
                    animeCardClick()
                }
            }
        }
    }
}

@Composable
private fun NewChaptersData(
    vm: HomeViewModel,
    animeCardClick : () -> Unit
) {
    vm.animeEvent.collectAsState().run {
        when(this.value) {
            is LatestAnimeEvent.Loading -> {
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier.fillMaxSize()
                ) {}
                CircularProgressIndicator()
            }
            is LatestAnimeEvent.Success -> {
                PromiseContent(
                    titleRow = stringResource(R.string.home_latest_chapters),
                    showMoreText = stringResource(R.string.home_show_more_btn_content),
                    animeData = (this.value as LatestAnimeEvent.Success).data
                ) {
                    vm.saveSelectedAnime(it)
                }
            }
            is LatestAnimeEvent.Error -> {}
        }
    }
    vm.saveSelectedAnimeEvent.collectAsState().run {
        OnSaveAnimeEventListener(saveSelectedAnimeEvent = this) { animeCardClick() }
    }
}

@Composable
private fun OnSaveAnimeEventListener(
    saveSelectedAnimeEvent: State<SaveSelectedAnimeEvent>,
    animeCardClick: () -> Unit
) {
    when(saveSelectedAnimeEvent.value) {
        is SaveSelectedAnimeEvent.Error -> {  }
        is SaveSelectedAnimeEvent.Loading -> {  }
        is SaveSelectedAnimeEvent.Success -> { animeCardClick() }
    }
}

@Composable
@Preview(showBackground = true)
fun HomeScreenPreview() {
    EclipseAnimeCTheme {
        HomeScreen() {}
    }
}