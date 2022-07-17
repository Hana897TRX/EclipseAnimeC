package com.hana897trx.eclipseanime.ui.components

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.hana897trx.eclipseanime.R

@Composable
fun RoundedTextField(
   text: String = "Dummy content"
) {
   OutlinedTextField(
      value = text,
      onValueChange = {},
      colors = TextFieldDefaults.outlinedTextFieldColors(
         focusedBorderColor = Color.White,
         unfocusedBorderColor = Color.White,
         textColor = Color.White
      ),
      readOnly = true,
      textStyle = MaterialTheme.typography.h6,
      shape = RoundedCornerShape(24.dp)
   )
}

@Composable
@Preview(showBackground = true, backgroundColor = 0x000)
fun RoundedTextFieldPreview() {
   MaterialTheme {
      RoundedTextField()
   }
}