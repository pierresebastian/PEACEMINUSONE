
package com.example.peaceminusone.API.data.remote.response

import com.google.gson.annotations.SerializedName

data class ProductsResponse (
    @field:SerializedName("responsedata")
    val responsedata : PostProducts,
)

data class PostProducts (
    @field:SerializedName("feeds")
    val postProducts : ArrayList<Products>,
)

data class Products(
    @field:SerializedName("productId")
    val id : Int,

    @field:SerializedName("productName")
    val productsName : String,

    @field:SerializedName("productImage")
    val productImageUrl : String,
)

