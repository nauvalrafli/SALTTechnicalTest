package com.example.salttechnicaltest.ui.component

import androidx.compose.foundation.Image
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import coil.compose.AsyncImagePainter
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import coil.size.Size

@Composable
fun WidgetImage(
    url: String,
    modifier: Modifier = Modifier
) {
    val painter = rememberAsyncImagePainter(
        model = ImageRequest.Builder(LocalContext.current)
            .data(url)
            .size(Size.ORIGINAL)
            .build()
    )

    when(painter.state) {
        AsyncImagePainter.State.Empty -> {
            Icon(
                imageVector = Icons.Default.AccountCircle,
                contentDescription = null,
                modifier = modifier
            )
        }
        is AsyncImagePainter.State.Error -> {
            Icon(
                imageVector = Icons.Default.AccountCircle,
                contentDescription = null,
                modifier = modifier
            )
        }
        is AsyncImagePainter.State.Loading -> {
            Image(
                painter = painter,
                contentDescription = null,
                modifier = modifier.roundedShimmer(true),
                contentScale = ContentScale.FillBounds
            )
        }
        is AsyncImagePainter.State.Success -> {
            Image(
                painter = painter,
                contentDescription = "avatar",
                modifier = modifier,
                contentScale = ContentScale.FillBounds
            )
        }
    }


}