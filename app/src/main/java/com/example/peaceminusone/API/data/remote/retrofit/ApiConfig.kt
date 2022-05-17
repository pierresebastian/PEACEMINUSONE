package com.example.peacemminusone.API.data.remote.retrofit

import com.bumptech.glide.RequestBuilder
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiConfig {

    val BASE_URL : String = "https://shoppingcontent.googleapis.com/"

    fun getApiService(): ApiServices {
        val loggingInterceptor = HttpLoggingInterceptor()
            .setLevel(HttpLoggingInterceptor.Level.BODY)
        val client: OkHttpClient = OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .build()
//        val request = Request.Builder()
//            .url("https://asos2.p.rapidapi.com/products/v2/list?store=US&offset=0&categoryId=4209&limit=48&country=US&sort=freshness&currency=USD&sizeSchema=US&lang=en-US")
//            .get()
//            .addHeader("X-RapidAPI-Host", "asos2.p.rapidapi.com")
//            .addHeader("X-RapidAPI-Key", "566f9a7740msh5296f41fb3a63bdp1facf2jsnc26f96ca7408")
//            .build()
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
        return retrofit.create(ApiServices::class.java)
    }
}