package com.example.quickmart.ui.navigation

import CartViewModel
import ProductViewModel
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.quickmart.ui.cart.CartScreen
import com.example.quickmart.ui.cart.Checkout
import com.example.quickmart.ui.favourite.FavouriteScreen
import com.example.quickmart.ui.product.ProductScreen

@Composable
fun AppNavHost(navController: NavHostController, paddingValues: PaddingValues) {
    NavHost(navController = navController, startDestination = "Shop") {
        composable("Shop") {
            // You need to pass the correct view models here
            ProductScreen(viewModel = ProductViewModel(), paddingValues = paddingValues)
        }
        composable("Cart") {
            // You need to pass the correct view model here
            CartScreen(cartViewModel = CartViewModel(), paddingValues = paddingValues) {
                navController.navigate("Shop")
            }
        }
        composable("Favourites") {
            FavouriteScreen(paddingValues = paddingValues)
        }
        composable("Checkout") {
            Checkout {
                navController.navigate("Shop")
            }
        }
    }
}