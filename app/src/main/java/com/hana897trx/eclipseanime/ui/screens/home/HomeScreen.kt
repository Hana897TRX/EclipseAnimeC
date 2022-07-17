package com.hana897trx.eclipseanime.ui.screens.home

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Scaffold
import androidx.compose.material.ScaffoldState
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.hana897trx.eclipseanime.ui.theme.EclipseAnimeCTheme
import androidx.hilt.navigation.compose.hiltViewModel
import com.hana897trx.eclipseanime.ui.components.PopularContent
import com.hana897trx.eclipseanime.ui.components.PromiseContent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch


@Composable
fun HomeScreen(vm : HomeViewModel = hiltViewModel<HomeViewModel>()) {
    val scaffoldState : ScaffoldState = rememberScaffoldState()
    Scaffold(scaffoldState = scaffoldState) {
        LazyColumn {
            item{
                PopularContent()
            }
            item {
                LatestAnimeLoader(vm, scaffoldState)
            }
        }
    }
}

@SuppressLint("CoroutineCreationDuringComposition")
@Composable
private fun LatestAnimeLoader(vm: HomeViewModel, scaffoldState: ScaffoldState) {
    val state = vm.latestAnimeEvent.collectAsState(initial = LatestAnimeEvent.Loading)
    val coroutineScope: CoroutineScope = rememberCoroutineScope()
    when(state.value) {
        is LatestAnimeEvent.Loading -> {
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                CircularProgressIndicator()
            }
        }
        is LatestAnimeEvent.Error -> {
            coroutineScope.launch {
                scaffoldState
                    .snackbarHostState
                    .showSnackbar(
                        message = (state.value as LatestAnimeEvent.Error).error
                    )
            }
        }
        is LatestAnimeEvent.Success -> {
            PromiseContent()
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