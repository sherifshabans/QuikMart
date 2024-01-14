import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.quickmart.data.model.CartItem
import com.example.quickmart.data.repository.CartRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CartViewModel : ViewModel() {
    private val _cartItems = MutableLiveData<List<CartItem>>()
    val cartItems: LiveData<List<CartItem>> get() = _cartItems

    private val _total = MutableLiveData<Double>()
    val total: LiveData<Double> get() = _total

    init {
        _cartItems.value = emptyList()
        _total.value = 0.0
    }

    fun clearCart() {
        CartRepository.clearItems()
        _cartItems.value = emptyList()
        _total.value = 0.0
    }

    fun addCartItem(cartItem: CartItem) {
        CartRepository.addCartItem(cartItem)
        updateCart()
    }

    fun updateItem(cartItem: CartItem, quantity: Int = 1) {
        CartRepository.updateItem(cartItem.productId, quantity)
        updateCart()
    }


    private fun updateCart() {
        viewModelScope.launch(Dispatchers.Main) {
            _cartItems.value = CartRepository.cartItems
            _total.value = CartRepository.getCartTotal()
        }
    }
}
