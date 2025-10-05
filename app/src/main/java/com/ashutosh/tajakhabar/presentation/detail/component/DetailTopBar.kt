package com.ashutosh.tajakhabar.presentation.detail.component

import android.content.res.Configuration
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.ashutosh.tajakhabar.R
import com.ashutosh.tajakhabar.ui.theme.TajaKhabarTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailTopBar(
    onBackClick : () -> Unit ,
    onBookMarkClick : () -> Unit ,
    onShareClick : ()-> Unit ,
    onBrowserBtnClick : () -> Unit
) {
    TopAppBar(
        modifier = Modifier.fillMaxWidth(),
        colors = TopAppBarDefaults.mediumTopAppBarColors(
            containerColor = Color.Transparent,
            actionIconContentColor = colorResource(id = R.color.body),
            navigationIconContentColor = colorResource( id = R.color.body)
        ),
        title = {},
        navigationIcon = {
            IconButton(onClick = onBackClick) {
                Icon(
                    painter = painterResource(R.drawable.ic_back_arrow),
                    contentDescription = null
                )
            }
        },
        actions = {

            IconButton(onClick = onBookMarkClick) {
                Icon(
                    painter = painterResource(R.drawable.ic_bookmark),
                    contentDescription = null
                )
            }

            IconButton(onClick = onBrowserBtnClick) {
                Icon(
                    painter = painterResource(R.drawable.ic_network),
                    contentDescription = null
                )
            }

            IconButton(onClick = onShareClick) {
                Icon(
                    imageVector = Icons.Default.Share,
                    contentDescription = null
                )
            }

        },

    )
}

@Preview(showBackground = true)
@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun DetailsTopBarPreview() {
    TajaKhabarTheme(dynamicColor = false) {
        DetailTopBar(onBackClick = {/* TODO */},
        onBookMarkClick ={ /* TODO */ } ,
        onShareClick = {/* TODO */} ,
        onBrowserBtnClick = {/* TODO */
        })
    }
}