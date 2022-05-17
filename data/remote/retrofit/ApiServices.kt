package com.example.peacemminusone.API.data.remote.retrofit

import com.example.peaceminusone.API.data.remote.response.ProductsResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.Path

interface ApiServices {
    @GET("shoes")
    @Headers("X-RapidAPI-Host:nike-products.p.rapidapi.com","X-RapidAPI-Key:566f9a7740msh5296f41fb3a63bdp1facf2jsnc26f96ca7408")

    fun getProducts(): Call<ArrayList<ProductsResponse>>
}
//    @GET("{weaponUuid}")
//    fun getSkinsByUuid(
//        @Path("weaponUuid") weaponUuid : String
//    ): Call<SkinsByUuidResponse>
