package com.ishan_android.newsapp.data.repository.news_source.datasource

import com.ishan_android.newsapp.model.source.Source

interface NewsCacheDataSource {
    suspend fun getNewsFromCache():List<Source>
    suspend fun saveNewsToCache(artists:List<Source>)

}