package com.ashutosh.tajakhabar.presentation.common

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun NewsButton(
    text : String ,
    onclick :() ->  Unit
) {

    Button(onClick = onclick,
        colors = ButtonDefaults.buttonColors(
            contentColor = Color.White,
            containerColor = MaterialTheme.colorScheme.primary,

        ),
        shape = RoundedCornerShape(size = 6.dp)
        ) {
        Text(text = text , style = MaterialTheme.typography.labelMedium.copy(fontWeight = FontWeight.SemiBold))
    }
}
@Composable
fun NewsTextButton(
    text : String ,
    onclick :() ->  Unit
) {

    TextButton(onClick = onclick) {
        Text(text = text ,
            style = MaterialTheme.typography.labelMedium.copy(fontWeight = FontWeight.SemiBold),
            color = Color.Blue
        )
    }
}