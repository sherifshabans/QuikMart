package com.example.quickmart.ui.product
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.*

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.quickmart.data.model.Product
import com.example.quickmart.data.repository.FavouriteRepository
import com.example.quickmart.ui.theme.QuickMartTheme

@Composable
fun ProductDetails(product: Product, onBackClicked: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        // Back button
        IconButton(
            onClick = { onBackClicked() },
            modifier = Modifier
                .align(Alignment.Start)
                .padding(8.dp)
        ) {
            Icon(Icons.Default.ArrowBack, contentDescription = null)
        }

        // Product details
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .background(MaterialTheme.colorScheme.primary)
        ) {
            Image(
                painterResource(
                    LocalContext.current.resources.getIdentifier(
                        product.imageName, "drawable", LocalContext.current.packageName
                    )
                ),
                null,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(8.dp)
            )
        }


        Spacer(modifier = Modifier.height(16.dp))

        var isFavorite by remember { mutableStateOf(false) }

        IconButton(
            onClick = {
                // Toggle the favorite status
                isFavorite = !isFavorite

                // Add or remove the product from favorites based on the status
                if (isFavorite) {
                    FavouriteRepository.addToFavourites(product)
                } else {
                    FavouriteRepository.removeFromFavourites(product)
                }
            },
            modifier = Modifier
                .align(Alignment.End)
                .padding(8.dp)
        ) {
            // Use either filled or border icon based on the favorite status
            Icon(
                if (isFavorite) Icons.Default.Favorite else Icons.Default.FavoriteBorder,
                contentDescription = null,
                tint = MaterialTheme.colorScheme.secondary
            )
        }
        Spacer(modifier = Modifier.height(16.dp))


        // Product information
        Text(
            text = product.title,
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(4.dp))

        Text(
            text = "Category: ${product.category}",
            style = MaterialTheme.typography.bodySmall
        )

        Spacer(modifier = Modifier.height(4.dp))

        Text(
            text = "Price: ${String.format("%.2f", product.price)}",
            style = MaterialTheme.typography.bodySmall
        )

        Spacer(modifier = Modifier.height(4.dp))

        StarRating(rating = product.rating)

        Spacer(modifier = Modifier.height(16.dp))

        // Product description
        Text(
            text = "Description: ${product.description}",
            style = MaterialTheme.typography.bodySmall
        )
    }
}

@Composable
fun StarRating(rating: Int) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 4.dp)
    ) {
        repeat(rating) {
            Icon(Icons.Default.Favorite, contentDescription = null, tint = MaterialTheme.colorScheme.secondary)
        }
        repeat(5 - rating) {
            Icon(Icons.Default.FavoriteBorder, contentDescription = null, tint = MaterialTheme.colorScheme.secondary)
        }
    }
}


