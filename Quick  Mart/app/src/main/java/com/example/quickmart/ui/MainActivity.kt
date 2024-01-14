
package com.example.quickmart.ui

import CartViewModel
import ProductViewModel
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import com.example.quickmart.data.repository.ProductRepository
import com.example.quickmart.ui.favourite.FavouriteViewModel
import com.example.quickmart.ui.home.HomeScreen
import com.example.quickmart.ui.theme.QuickMartTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
         val cartViewModel: CartViewModel by viewModels()
         val productViewModel: ProductViewModel by viewModels()
        val favouriteViewModel: FavouriteViewModel by viewModels()

        super.onCreate(savedInstanceState)
        setContent {
            QuickMartTheme {
                Surface(color = MaterialTheme.colorScheme.background) {
//                    this will initialize the list of products
                    ProductRepository.initProducts(this)
                    HomeScreen(cartViewModel,productViewModel,favouriteViewModel)
                }
            }
        }
    }
}
/*


package com.example.quickmart.ui


import CartViewModel
import ProductViewModel
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import com.example.quickmart.ui.favourite.FavouriteViewModel
import com.example.quickmart.ui.home.HomeScreen
import com.example.quickmart.ui.theme.QuickMartTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            QuickMartTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colorScheme.background) {
                    // You need to pass the correct view models here
                    HomeScreen(
                       cartViewModel = CartViewModel(),
                     productViewModel = ProductViewModel(),
                    )
                }
            }
        }
    }
}*/
