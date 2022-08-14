package com.hana897trx.eclipseanime.ui.screens.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.hana897trx.eclipseanime.ui.components.AnimeCard
import com.hana897trx.eclipseanime.ui.components.PopularContent
import com.hana897trx.eclipseanime.ui.components.PromiseContent
import com.hana897trx.eclipseanime.ui.theme.EclipseAnimeCTheme
import dagger.hilt.android.AndroidEntryPoint

@Composable
fun HomeScreen(homeViewModel: HomeViewModel = viewModel()) {
    Column(modifier = Modifier.fillMaxSize()) {
        LazyColumn {
            item {
                PopularContent()
            }
            items(3) {
                PromiseContent()
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun HomeScreenPreview() {
    EclipseAnimeCTheme {
        HomeScreen()
    }
}