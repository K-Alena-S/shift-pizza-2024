package com.example.shift_pizza_2024.history

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.example.shift_pizza_2024.data.Pizza
import coil.compose.rememberImagePainter

@Composable
fun ContentComponent(
    pizza: List<Pizza>,
    onItemClicked: (pizzaId: Long) -> Unit,
) {
    LazyColumn(modifier = Modifier.fillMaxHeight()) {
        items(pizza) { pizzas ->
            PizzaItem(
                pizzas,
                onItemClicked = { onItemClicked(pizzas.id) }
            )
        }
    }
}

@Composable
private fun PizzaItem(
    item: Pizza,
    onItemClicked: () -> Unit,
) {
    Column (
        Modifier
            .fillMaxWidth()
            .clickable(onClick = onItemClicked)
            .padding(vertical = 8.dp, horizontal = 16.dp),
    ) {
        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            Text(text = item.name)
            LoadImageFromUrl(url = "https://shift-backend.onrender.com" + item.img)
        }
    }
}

@Composable
fun LoadImageFromUrl(url: String) {
    Image(
        painter = rememberImagePainter(
            data = url,
            builder = {
                crossfade(true)
            }
        ),
        contentDescription = "Картинка пиццы",
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp),
        contentScale = ContentScale.Crop
    )
}
