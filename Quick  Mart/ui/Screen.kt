package com.example.quickmart.ui


import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.ShoppingCart

import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.rounded.Home
import androidx.compose.ui.graphics.vector.ImageVector


//constants you do not want to hard code, this class is not mandatory
//it just helps you not to make mistakes while typing the route or title etc...
sealed class Screen(val route: String, val title: String, val icon: ImageVector) {
    //    declare objects
    object productScreen : Screen("shop", "Shop",Icons.Default.Home)
    object cartScreen : Screen("cart", "Cart", Icons.Default.ShoppingCart)
    object favoriteScreen : Screen("favorite", "Favorite", Icons.Default.FavoriteBorder)
}
