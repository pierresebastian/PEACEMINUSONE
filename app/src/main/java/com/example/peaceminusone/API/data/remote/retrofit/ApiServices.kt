package com.example.peacemminusone.API.data.remote.retrofit

import com.example.peaceminusone.API.data.remote.response.ProductsResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiServices {
    @GET("getGalleryPosts/75039/?user_key=4de034dfe261a350a096a58231369246&offset=0&date_from=07/10/2021&&include_only_video_posts=false&include_only_image_posts=false&limit=500&format=json")

    fun getProducts(): Call<ProductsResponse>

//    @GET("{weaponUuid}")
//    fun getSkinsByUuid(
//        @Path("weaponUuid") weaponUuid : String
//    ): Call<SkinsByUuidResponse>
}