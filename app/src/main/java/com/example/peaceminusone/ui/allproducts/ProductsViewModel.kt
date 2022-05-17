package com.example.peaceminusone.ui.allproducts

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.peaceminusone.API.data.ProductsRepository
import com.example.peaceminusone.API.data.local.entity.ProductsEntity
import kotlinx.coroutines.launch

class ProductsViewModel(private val productsRepository: ProductsRepository) : ViewModel() {
    fun getHeadlineProducts() = productsRepository.getHeadlineProducts()

    fun getBookmarkedSkins() = productsRepository.getBookmarkedProducts()

    fun saveProducts(products: ProductsEntity) {
        viewModelScope.launch {
            productsRepository.setBookmarkedProducts(products, true)
        }
    }

    fun deleteProducts(products: ProductsEntity) {
        viewModelScope.launch {
            productsRepository.setBookmarkedProducts(products, false)
        }
    }
}