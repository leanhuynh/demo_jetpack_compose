package com.google.sample_jetpack_compose.component

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import coil.compose.rememberAsyncImagePainter

@Composable
fun NetworkImage(
    imageUrl: String,
    modifier: Modifier = Modifier,
    contentScale: ContentScale = ContentScale.Fit
) {
    Image(
        painter = rememberAsyncImagePainter(
            imageUrl
        ),
        contentDescription = null,
        modifier = modifier,
        contentScale = contentScale,
    )
}
