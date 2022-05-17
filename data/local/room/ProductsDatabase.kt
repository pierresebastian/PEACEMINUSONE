package com.example.peaceminusone.API.data.local.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.peaceminusone.API.data.local.entity.ProductsEntity

@Database(entities = [ProductsEntity::class], version = 1, exportSchema = false)
abstract class ProductsDatabase : RoomDatabase() {
    abstract fun productsDao(): ProductsDao

    companion object {
        @Volatile
        private var instance: ProductsDatabase? = null
        fun getInstance(context: Context): ProductsDatabase =
            instance ?: synchronized(this) {
                instance ?: Room.databaseBuilder(
                    context.applicationContext,
                    ProductsDatabase::class.java, "Products.db"
                ).build()
            }
    }
}