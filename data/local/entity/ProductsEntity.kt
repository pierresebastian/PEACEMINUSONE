package com.example.peaceminusone.API.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "products")
class ProductsEntity (

    @field:ColumnInfo(name = "name")
    @field:PrimaryKey
    val name: String,

    @field:ColumnInfo(name = "imageUrl")
    val imageUrl: String,

    @field:ColumnInfo(name = "bookmarked")
    var isBookmarked: Boolean
    )
