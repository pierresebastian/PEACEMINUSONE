
package com.example.peaceminusone.API.data.remote.response

import com.google.gson.annotations.SerializedName

data class ProductsResponse (
    @field:SerializedName("title")
    val productsName : String,

    @field:SerializedName("img")
    val productsImageUrl : String,
)
//    @field:SerializedName("")
//    val data : ArrayList<Products>,
//)
//
//data class Category (
//    @field:SerializedName("categories")
//    val payload : ArrayList<Products>,
//)
//
//data class Products(


