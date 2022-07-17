package com.hana897trx.eclipseanime.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.VerticalAlignmentLine
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.hana897trx.eclipseanime.data.remote.models.LatestM

@Composable
fun PromiseContent(
   list: List<LatestM> = emptyList(),
   moduleTitle: String = "",
   btnText: String = "",
   btnAction: () -> Unit = {}
) {
   Column(modifier = Modifier.fillMaxSize()) {
      Row(
         modifier = Modifier
            .fillMaxWidth()
            .padding(4.dp),
         horizontalArrangement = Arrangement.SpaceBetween,
         verticalAlignment = CenterVertically
      ) {
         Text(
            text = moduleTitle,
            style = MaterialTheme.typography.h6,
            modifier = Modifier.padding(start = 8.dp),
            fontWeight = FontWeight.Bold
         )
         OutlinedButton(
            onClick = { btnAction() },
            modifier = Modifier.padding(end = 8.dp)
         ) {
            Text(btnText)
         }
      }
      LazyRow {
         items(list) { core ->
            AnimeCard(
               coverUrl = core.coverUrl,
               title = core.title,
               genre = core.genre
            )
         }
      }
   }
}

@Composable
@Preview(showBackground = true)
fun PromiseContentPreview() {
   MaterialTheme {
      PromiseContent()
   }
}