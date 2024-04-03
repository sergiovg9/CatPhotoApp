package com.mexiti.catphotoapp.network

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import com.mexiti.catphotoapp.model.CatPhoto
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import retrofit2.http.GET

private const val BASE_URL = "https://picsum.photos"

private val retrofit = Retrofit.Builder()
    .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
    .baseUrl(BASE_URL)
    .build()

interface CatApiService{
    @GET("v2/list?limit=20&page=6")
    suspend fun getPhotos():List<CatPhoto>
}

object CatApi {
    val retrofitService: CatApiService by lazy{
        retrofit.create(CatApiService::class.java)
    }
}