
package com.example.peaceminusone.API.data.remote.response

import com.google.gson.annotations.SerializedName

data class ProductsResponse (
    @field:SerializedName("data")
    val data : ArrayList<Products>,
)

data class Products(
    @field:SerializedName("id")
    val id : Int,

    @field:SerializedName("name")
    val productsName : String,

    @field:SerializedName("imageUrl")
    val weaponImageUrl : String,
)

