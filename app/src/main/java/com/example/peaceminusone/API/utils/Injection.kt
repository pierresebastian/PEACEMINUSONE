package com.example.ppb_tubes.peaceminusone.API.utils

import android.content.Context
import com.example.peaceminusone.API.data.ProductsRepository
import com.example.peaceminusone.API.data.local.room.ProductsDatabase
import com.example.peacemminusone.API.data.remote.retrofit.ApiConfig

object Injection {

    fun provideRepository(context: Context) : ProductsRepository {
        val apiService = ApiConfig.getApiService()
        val database = ProductsDatabase.getInstance(context)
        val dao = database.productsDao()
        val appExecutors = AppExecutors()
        return ProductsRepository.getInstance(apiService, dao, appExecutors)
    }
}