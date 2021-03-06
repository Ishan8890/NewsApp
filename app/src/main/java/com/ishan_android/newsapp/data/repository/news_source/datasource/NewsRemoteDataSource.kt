package com.ishan_android.newsapp.data.repository.news_source.datasource

import com.ishan_android.newsapp.model.allnews.NewsModel
import com.ishan_android.newsapp.model.source.SourceModel
import retrofit2.Response

interface NewsRemoteDataSource {
    suspend fun getNewsFromServer(): Response<SourceModel>
    suspend fun getNewsHeadLinesFromServer(): Response<NewsModel>
    suspend fun getDetailNewsFromServer(id:String): Response<NewsModel>

}