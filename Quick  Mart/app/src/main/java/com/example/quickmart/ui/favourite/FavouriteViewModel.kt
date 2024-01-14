package com.example.quickmart.ui.favourite

// FavouriteViewModel.kt
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.quickmart.data.model.CartItem
import com.example.quickmart.data.model.Product
import com.example.quickmart.data.repository.CartRepository
import com.example.quickmart.data.repository.FavouriteRepository

class FavouriteViewModel : ViewModel() {

    private val _favouriteItems = MutableLiveData<List<Product>>()
    val favouriteItems: LiveData<List<Product>> get() = _favouriteItems

    init {
        _favouriteItems.value = FavouriteRepository.getFavourites()
    }

    fun removeFromFavourites(product: Product) {
        val updatedList = _favouriteItems.value.orEmpty().toMutableList()
        updatedList.remove(product)
        _favouriteItems.value = updatedList
    }

    fun addToCartAll() {
        val favouriteProducts = _favouriteItems.value.orEmpty()
        for (product in favouriteProducts) {
            val cartItem = CartItem(product.id, 1)
            CartRepository.addCartItem(cartItem)
        }
        _favouriteItems.value = emptyList()
    }
}
