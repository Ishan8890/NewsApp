package com.ishan_android.newsapp.data.api

import com.ishan_android.newsapp.model.source.Source
import com.ishan_android.newsapp.model.source.SourceModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsService {
    //https://newsapi.org/v2/sources?apiKey=a40e2d7b33cc4a58bca80e711a1f0117
    @GET("/v2/sources")
    suspend fun getNewsSources(
        @Query(
            "apiKey"
        ) apiKey: String
    ): Response<SourceModel>

    //https://newsapi.org/v2/everything?q=al-jazeera-english&apiKey=a40e2d7b33cc4a58bca80e711a1f0117
    @GET("/v2/everything")
    suspend fun getAllNews(
        @Query("api_key") apiKey: String
    ): Response<SourceModel>

}