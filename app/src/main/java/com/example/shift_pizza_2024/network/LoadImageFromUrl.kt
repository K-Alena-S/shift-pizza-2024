package com.example.shift_pizza_2024.network

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter

@Composable
fun LoadImageFromUrl(url: String) {
    Image(
        painter = rememberImagePainter(
            data = "https://shift-backend.onrender.com$url",
            builder = {
                crossfade(true)
            }
        ),
        contentDescription = "Картинка пиццы",
        modifier = Modifier
            .width(200.dp)
            .height(200.dp),
        contentScale = ContentScale.Crop
    )
}