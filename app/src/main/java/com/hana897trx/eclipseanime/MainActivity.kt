package com.hana897trx.eclipseanime

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.hana897trx.eclipseanime.data.remote.models.LatestM
import com.hana897trx.eclipseanime.ui.screens.details.DetailsScreen
import com.hana897trx.eclipseanime.ui.screens.details.DetailsViewModel
import com.hana897trx.eclipseanime.ui.screens.home.HomeScreen
import com.hana897trx.eclipseanime.ui.screens.home.viewModel.HomeViewModel
import com.hana897trx.eclipseanime.ui.theme.EclipseAnimeCTheme
import com.hana897trx.eclipseanime.utils.Screens.DETAILS_SCREEN
import com.hana897trx.eclipseanime.utils.Screens.DETAILS_SCREEN_ANIME_DATA_ARG
import com.hana897trx.eclipseanime.utils.Screens.HOME_SCREEN
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EclipseAnimeCTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    NavMap()
                }
            }
        }
    }
}

@Composable
fun NavMap() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = HOME_SCREEN
    ) {
        composable(HOME_SCREEN) { backStackEntry ->
            val vm: HomeViewModel = hiltViewModel(backStackEntry)
            HomeScreen(vm) {
                navController.navigate(DETAILS_SCREEN)
            }
        }
        composable(DETAILS_SCREEN) { backStackEntry ->
            val vm: DetailsViewModel = hiltViewModel(backStackEntry)
            DetailsScreen(vm)
        }
    }
}