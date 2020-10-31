package com.ishan_android.newsapp.data.repository.news_source.datasourceImpl

import com.ishan_android.newsapp.data.db.SourceNewsDao
import com.ishan_android.newsapp.data.repository.news_source.datasource.NewsLocalDataSource
import com.ishan_android.newsapp.model.source.Source
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NewsLocalDataSourceImpl(private val newsDao: SourceNewsDao) : NewsLocalDataSource {
    override suspend fun getNewsFromDB(): List<Source> {
        return newsDao.getNews()
    }

    override suspend fun saveNewsToDB(newsList: List<Source>) {
        CoroutineScope(Dispatchers.IO).launch {
            newsDao.saveNews(newsList)
        }
    }

    override suspend fun clearAll() {
        CoroutineScope(Dispatchers.IO).launch {
            newsDao.deleteAllNews()
        }

    }
}