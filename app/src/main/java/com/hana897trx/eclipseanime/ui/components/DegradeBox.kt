package com.hana897trx.eclipseanime.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun DegradeBox(degradeBox: DegradeBox, content : @Composable () -> Unit = {}) {
   Box(
      modifier = Modifier
         .background(
            brush = when(degradeBox) {
               DegradeBox.BOTTOM -> {
                  Brush.verticalGradient(
                     colors = listOf(
                        Color.Transparent,
                        Color.Black
                     )
                  )
               }
               DegradeBox.TOP -> {
                  Brush.verticalGradient(
                     colors = listOf(
                        Color.Black,
                        Color.Transparent
                     )
                  )
               }
               DegradeBox.LEFT -> {
                  Brush.horizontalGradient(
                     colors = listOf(
                        Color.Black,
                        Color.Transparent
                     )
                  )
               }
               DegradeBox.RIGHT -> {
                  Brush.horizontalGradient(
                     colors = listOf(
                        Color.Transparent,
                        Color.Black
                     )
                  )
               }
            }
         ).fillMaxSize()
   ) {
      content()
   }
}

@Composable
@Preview(showBackground = true)
fun DegradeBoxPreview() {
   MaterialTheme {
      DegradeBox(DegradeBox.BOTTOM)
   }
}

enum class DegradeBox {
   BOTTOM,
   TOP,
   LEFT,
   RIGHT
}