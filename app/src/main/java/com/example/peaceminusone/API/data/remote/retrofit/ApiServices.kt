package com.example.peacemminusone.API.data.remote.retrofit

import com.example.peaceminusone.API.data.remote.response.ProductsResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiServices {
    @GET("content/v2.1/{merchantId}/products/{productId}")

    fun getProducts(): Call<ProductsResponse>

//    @GET("{weaponUuid}")
//    fun getSkinsByUuid(
//        @Path("weaponUuid") weaponUuid : String
//    ): Call<SkinsByUuidResponse>
}