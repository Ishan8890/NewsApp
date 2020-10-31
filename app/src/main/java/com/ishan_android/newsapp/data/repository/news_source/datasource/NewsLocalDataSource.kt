package com.ishan_android.newsapp.data.repository.news_source.datasource

import com.ishan_android.newsapp.model.source.Source

interface NewsLocalDataSource {
    suspend fun getNewsFromDB():List<Source>
    suspend fun saveNewsToDB(artists:List<Source>)
    suspend fun clearAll()
}