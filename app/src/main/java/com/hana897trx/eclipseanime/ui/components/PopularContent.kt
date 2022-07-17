package com.hana897trx.eclipseanime.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.hana897trx.eclipseanime.R

@Composable
fun PopularContent() {
   Column {
      Box(
         modifier = Modifier.fillMaxWidth()
      ) {
         Image(
            painter = painterResource(id = R.drawable.demo_cover),
            contentDescription = "",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier.fillMaxSize()
         )
         Box(modifier = Modifier.fillMaxWidth()) {
            DegradeBox(degradeBox = DegradeBox.TOP) {
               Image(
                  painter = painterResource(id = R.drawable.eclipse_logo),
                  contentDescription = "",
                  modifier = Modifier.padding(8.dp)
               )
            }
         }
         Box(
            modifier = Modifier
               .fillMaxWidth()
               .height(150.dp)
               .align(alignment = Alignment.BottomCenter)
         ) {
            DegradeBox(degradeBox = DegradeBox.BOTTOM) {
               Column(
                  modifier = Modifier
                     .fillMaxSize()
                     .padding(12.dp)
               ) {
                  Row(
                     modifier = Modifier.fillMaxWidth(),
                     horizontalArrangement = Arrangement.SpaceBetween
                  ) {
                     Column(
                        modifier = Modifier
                           .weight(1F)
                           .padding(
                              end = 8.dp
                           )
                     ) {
                        RoundedTextField(
                           text = "Anime"
                        )
                     }
                     Column(
                        modifier = Modifier
                           .weight(1F)
                           .padding(
                              start = 8.dp
                           )
                     ) {
                        RoundedTextField(
                           text = "Episode 8"
                        )
                     }
                  }
                  Text(
                     text = "Demon Slayer: Kimetsu no Yaiba",
                     style = MaterialTheme.typography.h5,
                     fontWeight = FontWeight.Bold,
                     color = Color.White,
                     maxLines = 2,
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
fun PopularContentPreview() {
   MaterialTheme {
      PopularContent()
   }
}