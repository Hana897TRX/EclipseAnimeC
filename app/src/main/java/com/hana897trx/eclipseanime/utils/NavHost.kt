package com.hana897trx.eclipseanime.utils

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.hana897trx.eclipseanime.ui.screens.home.HomeScreen
import com.hana897trx.eclipseanime.ui.screens.home.HomeViewModel
import com.hana897trx.eclipseanime.utils.NavigationRoutes.HOME_FEED

@Composable
fun AppCore() {
   val navController = rememberNavController()
   NavHost(navController = navController, startDestination = HOME_FEED) {
      composable(HOME_FEED) {
         val vm = hiltViewModel<HomeViewModel>()
         HomeScreen(vm = vm)
      }
   }
}