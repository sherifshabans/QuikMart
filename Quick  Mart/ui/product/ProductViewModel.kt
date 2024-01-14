import android.util.Log
import androidx.compose.runtime.Composable
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.quickmart.data.model.Product
import com.example.quickmart.data.repository.ProductRepository

class ProductViewModel : ViewModel() {
    private val _products = MutableLiveData<List<Product>>()
    val products: LiveData<List<Product>> get() = _products


    private val _query = MutableLiveData<String>()
    val query: LiveData<String> get() = _query

    private val _filter = MutableLiveData<String>()
    val filter: LiveData<String> get() = _filter

    init {
        // Initialize products when ViewModel is created
        _products.value = ProductRepository.getProducts("")
        _query.value = ""
        _filter.value = "All"

        Log.d("ProductViewModel", "Initial products: ${_products.value}.")
    }

    fun setQuery(query: String) {
        _query.value = query
        updateProducts()
    }

    fun setFilter(filter: String) {
        _filter.value = filter
        updateProducts()
    }

    private fun updateProducts() {
        _products.value = ProductRepository.getProducts(_query.value.orEmpty(), _filter.value.orEmpty())
    }
}
