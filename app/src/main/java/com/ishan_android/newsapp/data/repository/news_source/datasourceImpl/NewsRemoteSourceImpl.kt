package com.ishan_android.newsapp.data.repository.news_source.datasourceImpl

import com.ishan_android.newsapp.data.api.NewsService
import com.ishan_android.newsapp.data.repository.news_source.datasource.NewsRemoteDataSource
import com.ishan_android.newsapp.model.source.SourceModel
import retrofit2.Response

class NewsRemoteSourceImpl(private val apiService:NewsService,private val apiKey:String) :NewsRemoteDataSource {
    override suspend fun getNewsFromServer(): Response<SourceModel> = apiService.getNewsSources(apiKey)



}