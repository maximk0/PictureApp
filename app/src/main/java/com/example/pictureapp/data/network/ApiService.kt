package com.example.pictureapp.data.network

import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("v2/list")
    suspend fun getRandomPhotos(@Query("page") page: Int): List<PhotoDto>

}
