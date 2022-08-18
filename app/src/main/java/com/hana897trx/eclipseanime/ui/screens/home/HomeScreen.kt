package com.hana897trx.eclipseanime.ui.screens.home

import android.provider.Settings.Global.getString
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.hana897trx.eclipseanime.R
import com.hana897trx.eclipseanime.data.remote.models.LatestM
import com.hana897trx.eclipseanime.ui.components.AnimeCard
import com.hana897trx.eclipseanime.ui.components.PopularContent
import com.hana897trx.eclipseanime.ui.components.PromiseContent
import com.hana897trx.eclipseanime.ui.theme.EclipseAnimeCTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.onEach

@Composable
fun HomeScreen(
    homeViewModel: HomeViewModel = viewModel(),
    animeCardClick : (anime: LatestM) -> Unit
) {
    Column(modifier = Modifier.fillMaxSize()) {
        LazyColumn {
            item {
                PopularContent()
            }
            item {
                NewChaptersData(homeViewModel) {
                    animeCardClick(it)
                }
            }
            /*items(3) {
                PromiseContent()
            }*/
        }
    }
}

@Composable
private fun NewChaptersData(
    vm: HomeViewModel,
    animeCardClick : (anime: LatestM) -> Unit
) {
    val response = vm.animeEvent.collectAsState()
    when(response.value) {
        is LatestAnimeEvent.Loading -> {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier.fillMaxSize()
            ) {

            }
            CircularProgressIndicator()
        }
        is LatestAnimeEvent.Success -> {
            PromiseContent(
                titleRow = stringResource(R.string.home_latest_chapters),
                showMoreText = stringResource(R.string.home_show_more_btn_content),
                animeData = (response.value as LatestAnimeEvent.Success).data
            ) {
                animeCardClick(it)
            }
        }
        is LatestAnimeEvent.Error -> {

        }
    }
}

@Composable
@Preview(showBackground = true)
fun HomeScreenPreview() {
    EclipseAnimeCTheme {
        HomeScreen() {}
    }
}