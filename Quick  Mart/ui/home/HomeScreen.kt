/*
package com.example.quickmart.ui.home
    
import CartViewModel
import ProductViewModel
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
    import androidx.compose.material.icons.outlined.FavoriteBorder
    import androidx.compose.material.icons.outlined.ShoppingCart
    import androidx.compose.material3.BottomAppBar
    import androidx.compose.material3.ExperimentalMaterial3Api
    import androidx.compose.material3.Icon
    import androidx.compose.material3.NavigationBarItem
    import androidx.compose.material3.NavigationBarItemDefaults
    import androidx.compose.material3.Scaffold
    import androidx.compose.material3.Text
    import androidx.compose.runtime.Composable
    import androidx.compose.runtime.getValue
    import androidx.compose.runtime.mutableStateOf
    import androidx.compose.runtime.remember
    import androidx.compose.runtime.setValue
    import androidx.compose.ui.Modifier
    import androidx.compose.ui.graphics.Color
    import androidx.compose.ui.res.painterResource
    import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.example.quickmart.GetCurrentRoute
import com.example.quickmart.R
    import com.example.quickmart.ui.favourite.FavouriteViewModel
    import com.example.quickmart.ui.navigation.AppNavHost


*//*

*/
/*
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(cartViewModel: CartViewModel,productViewModel: ProductViewModel , favouriteViewModel: FavouriteViewModel) {
  //      val screens = listOf("Shop", "Cart", "Favourites")
        var selectedScreen by remember { mutableStateOf("Shop") }

    val navController = rememberNavController()
    val screens = listOf(
        Screen.productScreen,
        Screen.cartScreen,
        Screen.favoriteScreen
    )
    
        Scaffold(bottomBar = {
            BottomAppBar(containerColor = Color.White) {
                screens.forEach { screen ->
                    NavigationBarItem(
                        selected = GetCurrentRoute(navController) == route,
                        onClick = { navController.navigate(route) },
                        icon = {
                            Icon(
                                imageVector = icon,
                                contentDescription = ""
                            )
                        },
                        label = { Text(text = title) },
                        alwaysShowLabel = GetCurrentRoute(navController) == route
                        ,colors = NavigationBarItemDefaults.colors(
                            selectedIconColor = Color.hsl(150F, 0.73F, 0.38F),
                            selectedTextColor = Color.hsl(150F, 0.73F, 0.38F),
                            indicatorColor = Color.White
                        )
                    )
                }
            }
        }) {
            AppNavHost(navController = navController, paddingValues = it)

        }
    
        }
*//*
*/
/*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen() {
    val navController = rememberNavController()

    val cartViewModel: CartViewModel = viewModel()
    val productViewModel: ProductViewModel = viewModel()
    val favouriteViewModel: FavouriteViewModel = viewModel()

    Scaffold(
        bottomBar = {
            BottomAppBar(containerColor = Color.White) {
                val screens = listOf("Shop", "Cart", "Favourites")
                screens.forEach { screen ->
                    NavigationBarItem(
                        selected = GetCurrentRoute(navController) == screen,
                        onClick = { navController.navigate(screen) },
                        icon = {
                            when (screen) {
                                "Shop" -> Icon(
                                    painterResource(R.drawable.baseline_storefront_24),
                                    null,
                                    Modifier.size(30.dp)
                                )
                                "Cart" -> Icon(Icons.Outlined.ShoppingCart, null, Modifier.size(30.dp))
                                "Favourites" -> Icon(
                                    Icons.Outlined.FavoriteBorder,
                                    null,
                                    Modifier.size(30.dp)
                                )
                            }
                        },
                        label = { Text(text = screen) },
                        colors = NavigationBarItemDefaults.colors(
                            selectedIconColor = Color.hsl(150F, 0.73F, 0.38F),
                            selectedTextColor = Color.hsl(150F, 0.73F, 0.38F),
                            indicatorColor = Color.White
                        )
                    )
                }
            }
        }
    ) {
        AppNavHost(navController = navController, paddingValues = it, cartViewModel, productViewModel, favouriteViewModel)
    }
}


// HomeScreen.kt
*//*

*/
/*
package com.example.quickmart.ui.home

import CartViewModel
import ProductViewModel
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.example.quickmart.R
import com.example.quickmart.data.repository.CartRepository
import com.example.quickmart.ui.favourite.FavouriteViewModel
import com.example.quickmart.ui.navigation.AppNavHost

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(cartViewModel: CartViewModel, productViewModel: ProductViewModel,
               favouriteViewModel : FavouriteViewModel) {
    val screens = listOf("Shop", "Cart", "Favourites")
    var selectedScreen by remember { mutableStateOf("Shop") }
    val navController = rememberNavController()
    val screens = listOf(
        Screen.FirstScreen,
        Screen.SecondScreen,
        Screen.CartScreen
    )
    Scaffold(bottomBar = {
        BottomAppBar(containerColor = Color.White) {
            screens.forEach { screen ->
                NavigationBarItem(
                    selectedScreen == screen,
                    onClick = {
                        selectedScreen = screen
                        navController.navigate(screen)
                    },
                    icon = {
                        when (screen) {
                            "Shop" -> Icon(
                                painterResource(R.drawable.baseline_storefront_24),
                                null,
                                Modifier.size(30.dp)
                            )
                            "Cart" -> Icon(Icons.Outlined.ShoppingCart, null, Modifier.size(30.dp))
                            "Favourites" -> Icon(
                                Icons.Outlined.FavoriteBorder,
                                null,
                                Modifier.size(30.dp)
                            )
                        }
                    },
                    label = { Text(screen) },
                    colors = NavigationBarItemDefaults.colors(
                        selectedIconColor = Color.hsl(150F, 0.73F, 0.38F),
                        selectedTextColor = Color.hsl(150F, 0.73F, 0.38F),
                        indicatorColor = Color.White
                    )
                )
            }
        }
    }) {
        AppNavHost(navController = navController, paddingValues = it)
    }
}
*//*
*/
/*


*//*

// HomeScreen.kt
package com.example.quickmart.ui.home

import CartViewModel
import ProductViewModel
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.example.quickmart.R
import com.example.quickmart.data.repository.CartRepository
import com.example.quickmart.ui.favourite.FavouriteViewModel
import com.example.quickmart.ui.navigation.AppNavHost

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(cartViewModel: CartViewModel, productViewModel: ProductViewModel, favouriteViewModel : FavouriteViewModel) {
    val screens = listOf("Shop", "Cart", "Favourites")
    var selectedScreen by remember { mutableStateOf("Shop") }
    val navController = rememberNavController()

    Scaffold(bottomBar = {
        BottomAppBar(containerColor = Color.White) {
            screens.forEach { screen ->
                NavigationBarItem(
                    selectedScreen == screen,
                    onClick = {
                        selectedScreen = screen
                        navController.navigate(screen)
                    },
                    icon = {
                        when (screen) {
                            "Shop" -> Icon(
                                painterResource(R.drawable.baseline_storefront_24),
                                null,
                                Modifier.size(30.dp)
                            )
                            "Cart" -> Icon(Icons.Outlined.ShoppingCart, null, Modifier.size(30.dp))
                            "Favourites" -> Icon(
                                Icons.Outlined.FavoriteBorder,
                                null,
                                Modifier.size(30.dp)
                            )
                        }
                    },
                    label = { Text(screen) },
                    colors = NavigationBarItemDefaults.colors(
                        selectedIconColor = Color.hsl(150F, 0.73F, 0.38F),
                        selectedTextColor = Color.hsl(150F, 0.73F, 0.38F),
                        indicatorColor = Color.White
                    )
                )
            }
        }
    }) {
        AppNavHost(navController = navController, paddingValues = it)
    }
}*/
package com.example.quickmart.ui.home

import CartViewModel
import ProductViewModel
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.quickmart.R
import com.example.quickmart.data.repository.CartRepository
import com.example.quickmart.ui.cart.CartScreen
import com.example.quickmart.ui.cart.Checkout
import com.example.quickmart.ui.favourite.FavouriteScreen
import com.example.quickmart.ui.favourite.FavouriteViewModel
import com.example.quickmart.ui.product.ProductScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    cartViewModel: CartViewModel,
    productViewModel: ProductViewModel,
    favouriteViewModel: FavouriteViewModel
) {
    val screens = listOf("Shop", "Cart", "Favourites")
    var selectedScreen by remember { mutableStateOf("Shop") }


    Scaffold(bottomBar = {
        BottomAppBar(containerColor = Color.White) {
            screens.forEach { screen ->
                NavigationBarItem(
                    selectedScreen == screen,
                    onClick = {
                        selectedScreen = screen
                    },
                    icon = {
                        when (screen) {
                            "Shop" -> Icon(
                                painterResource(R.drawable.baseline_storefront_24),
                                null,
                                Modifier.size(30.dp)
                            )

                            "Cart" -> Icon(Icons.Outlined.ShoppingCart, null, Modifier.size(30.dp))
                            "Favourites" -> Icon(
                                Icons.Outlined.FavoriteBorder,
                                null,
                                Modifier.size(30.dp)
                            )
                        }
                    },
                    label = { Text(screen) },
                    colors = NavigationBarItemDefaults.colors(
                        selectedIconColor = Color.hsl(150F, 0.73F, 0.38F),
                        selectedTextColor = Color.hsl(150F, 0.73F, 0.38F),
                        indicatorColor = Color.White
                    )
                )
            }
        }
    }) {

        when (selectedScreen) {
            "Shop" -> ProductScreen(productViewModel,it)
            "Cart" -> CartScreen(paddingValues = it,cartViewModel) {
                CartRepository.clearItems()
                selectedScreen = "Checkout"
            }

            "Favourites" -> FavouriteScreen(it, favouriteViewModel)
            "Checkout" -> {
                Checkout {
                    selectedScreen = "Shop"
                }
            }
        }

    }
}