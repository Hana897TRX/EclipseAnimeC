package com.hana897trx.eclipseanime.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.SubcomposeAsyncImage
import com.hana897trx.eclipseanime.ui.theme.EclipseAnimeCTheme

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun AnimeCard(
   coverUrl: String = "",
   title: String = "Dummy text",
   genre: String = "Action"
) {
   Column(modifier = Modifier.fillMaxSize()) {
      Card(
         modifier = Modifier
            .width(175.dp)
            .height(300.dp)
            .padding(8.dp),
         shape = RoundedCornerShape(6.dp),
         onClick = {}
      ) {
         Column(modifier = Modifier
            .fillMaxWidth(1.0F)
            .fillMaxHeight(0.90F)) {
            SubcomposeAsyncImage(
               model = coverUrl,
               loading = {
                  CircularProgressIndicator()
               },
               contentDescription = title
            )
            Box(modifier = Modifier.padding(4.dp)) {
               Column(modifier = Modifier.fillMaxSize()) {
                  Text(
                     text = title,
                     color = Color.Black,
                     style = MaterialTheme.typography.subtitle1.copy(fontWeight = FontWeight.Bold),
                     maxLines = 2,
                     modifier = Modifier.fillMaxWidth()
                  )
                  Text(
                     text = genre,
                     color = Color.Gray,
                     style = MaterialTheme.typography.subtitle2,
                     modifier = Modifier.fillMaxWidth()
                  )
               }
            }
         }
      }
   }
}

@Composable
@Preview(showBackground = true)
fun AnimeCardPreview() {
   EclipseAnimeCTheme {
      AnimeCard()
   }
}