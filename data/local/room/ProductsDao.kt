package com.example.peaceminusone.API.data.local.room

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.peaceminusone.API.data.local.entity.ProductsEntity

@Dao
interface ProductsDao {
    @Query("SELECT * FROM products ORDER BY name ASC")
    fun getProducts(): LiveData<List<ProductsEntity>>

    @Query("SELECT * FROM products where bookmarked = 1")
    fun getBookmarkedProducts(): LiveData<List<ProductsEntity>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertProducts(news: List<ProductsEntity>)

    @Update
    fun updateProducts(skins: ProductsEntity)

    @Query("DELETE FROM products WHERE bookmarked = 0")
    fun deleteAll()

    @Query("SELECT EXISTS(SELECT * FROM products WHERE name = :title AND bookmarked = 1)")
    fun isProductsBookmarked(title: String): Boolean
}