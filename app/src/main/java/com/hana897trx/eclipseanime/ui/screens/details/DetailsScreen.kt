package com.hana897trx.eclipseanime.ui.screens.details

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.hana897trx.eclipseanime.data.remote.models.LatestM

@Composable
fun DetailsScreen(
    viewModel: DetailsViewModel = hiltViewModel()
) {
    Column(modifier = Modifier.fillMaxSize()) {
        Text(text = "Anime Details")
    }
}

@Composable
@Preview(showBackground = true)
fun DetailsScreenPreview() {
    DetailsScreen()
}