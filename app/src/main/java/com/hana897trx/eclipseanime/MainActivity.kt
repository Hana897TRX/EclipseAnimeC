package com.hana897trx.eclipseanime

import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.google.gson.Gson
import com.hana897trx.eclipseanime.data.remote.models.LatestM
import com.hana897trx.eclipseanime.ui.screens.details.DetailsScreen
import com.hana897trx.eclipseanime.ui.screens.home.HomeScreen
import com.hana897trx.eclipseanime.ui.screens.home.HomeViewModel
import com.hana897trx.eclipseanime.ui.theme.EclipseAnimeCTheme
import com.hana897trx.eclipseanime.utils.AssetParamType
import com.hana897trx.eclipseanime.utils.Screens.DETAILS_SCREEN
import com.hana897trx.eclipseanime.utils.Screens.DETAILS_SCREEN_ANIME_DATA_ARG
import com.hana897trx.eclipseanime.utils.Screens.HOME_SCREEN
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.internal.lifecycle.HiltViewModelFactory

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EclipseAnimeCTheme {
                val navController = rememberNavController()
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    NavMap(navHostController = navController)
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    EclipseAnimeCTheme {
        Greeting("Android")
    }
}

@Composable
fun NavMap(navHostController: NavHostController) {
    NavHost(
        navController = navHostController,
        startDestination = HOME_SCREEN
    ) {
        composable(HOME_SCREEN) { backStackEntry ->
            val vm : HomeViewModel = hiltViewModel(backStackEntry)
            HomeScreen(vm) { animeData ->
                backStackEntry.savedStateHandle[DETAILS_SCREEN_ANIME_DATA_ARG] = animeData
                navHostController.navigate(DETAILS_SCREEN)
            }
        }
        composable(DETAILS_SCREEN) { backStackEntry ->
            val animeData = backStackEntry.savedStateHandle.get<LatestM>(DETAILS_SCREEN_ANIME_DATA_ARG)
            animeData?.run {
                DetailsScreen(animeData)
            }
        }
    }
}