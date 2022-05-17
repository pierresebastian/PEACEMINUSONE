package com.example.peaceminusone.API.data

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import com.example.peaceminusone.API.data.local.entity.ProductsEntity
import com.example.peaceminusone.API.data.local.room.ProductsDao
import com.example.peaceminusone.API.data.remote.response.ProductsResponse
import com.example.peacemminusone.API.data.remote.retrofit.ApiServices
import com.example.ppb_tubes.peaceminusone.API.utils.AppExecutors
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*
import kotlin.collections.ArrayList

class ProductsRepository private constructor(
    private val apiService: ApiServices,
    private val productsDao: ProductsDao,
    private val appExecutors: AppExecutors
) {

    private val result = MediatorLiveData<Result<List<ProductsEntity>>>()

    fun getHeadlineProducts(): LiveData<Result<List<ProductsEntity>>> {
        result.value = Result.Loading
        val client = apiService.getProducts()
        client.enqueue(object : Callback<ArrayList<ProductsResponse>> {
            override fun onResponse(call: Call<ArrayList<ProductsResponse>>, response: Response<ArrayList<ProductsResponse>>) {
                if (response.isSuccessful) {
                    val data = response.body()!!
                    val productsList = ArrayList<ProductsEntity>()
                    appExecutors.diskIO.execute {
                        data.forEach { products_article ->
                            val isBookmarked = productsDao.isProductsBookmarked(products_article.productsName)
                                val product = ProductsEntity(
                                    products_article.productsName,
                                    products_article.productsImageUrl,
                                    isBookmarked
                                )
                                productsList.add(product)
                        }
                        productsDao.deleteAll()
                        productsDao.insertProducts(productsList)
                    }
                }
            }

            override fun onFailure(call: Call<ArrayList<ProductsResponse>>, t: Throwable) {
                result.value = Result.Error(t.message.toString())
            }
        })
        val localData = productsDao.getProducts()
        result.addSource(localData) { newData: List<ProductsEntity> ->
            result.value = Result.Success(newData)
        }
        return result
    }

    fun getBookmarkedProducts(): LiveData<List<ProductsEntity>> {
        return productsDao.getBookmarkedProducts()
    }

    fun setBookmarkedProducts(products: ProductsEntity, bookmarkState: Boolean) {
        appExecutors.diskIO.execute {
            products.isBookmarked = bookmarkState
            productsDao.updateProducts(products)
        }
    }

    companion object {

        @Volatile
        private var instance: ProductsRepository? = null
        fun getInstance(
            apiService: ApiServices,
            productsDao: ProductsDao,
            appExecutors: AppExecutors
        ): ProductsRepository =
            instance ?: synchronized(this) {
                instance ?: ProductsRepository(apiService, productsDao, appExecutors)
            }.also { instance = it }
    }
}