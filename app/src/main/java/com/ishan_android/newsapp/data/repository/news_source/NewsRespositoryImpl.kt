package com.ishan_android.newsapp.data.repository.news_source

import android.util.Log
import com.ishan_android.newsapp.data.repository.news_source.datasource.NewsCacheDataSource
import com.ishan_android.newsapp.data.repository.news_source.datasource.NewsLocalDataSource
import com.ishan_android.newsapp.data.repository.news_source.datasource.NewsRemoteDataSource
import com.ishan_android.newsapp.domain.repository.NewsRepository
import com.ishan_android.newsapp.model.source.Source
import java.lang.Exception

class NewsRespositoryImpl(
    private val newsCacheDataSource:NewsCacheDataSource,
    private val newsLocalDataSource: NewsLocalDataSource,
    private val newsRemoteDataSource: NewsRemoteDataSource
): NewsRepository {
    override suspend fun getNewsSource(): List<Source>? {
        return getNewsFromCache()
    }

    override suspend fun updateNewsSource(): List<Source>? {
        val newListOfArtist = getNewsFromAPI()
        newsLocalDataSource.clearAll()
        newsLocalDataSource.saveNewsToDB(newListOfArtist)
        newsCacheDataSource.saveNewsToCache(newListOfArtist)
        return newListOfArtist
    }

    suspend fun getNewsFromAPI(): List<Source> {
        lateinit var newsList: List<Source>
        try {
            val response = newsRemoteDataSource.getNewsFromServer()
            val body = response.body()
            if(body!=null){
                newsList = body.sources
            }
        } catch (exception: Exception) {
            Log.i("MyTag", exception.message.toString())
        }
        return newsList
    }

    suspend fun getNewsFromDB():List<Source>{
        lateinit var newsList: List<Source>
        try {
            newsList = newsLocalDataSource.getNewsFromDB()
        } catch (exception: Exception) {
            Log.i("MyTag", exception.message.toString())
        }
        if(newsList.size>0){
            return newsList
        }else{
            newsList= getNewsFromAPI()
            newsLocalDataSource.saveNewsToDB(newsList)
        }

        return newsList
    }

    suspend fun getNewsFromCache():List<Source>{
        lateinit var newsList: List<Source>
        try {
            newsList = newsCacheDataSource.getNewsFromCache()
        } catch (exception: Exception) {
            Log.i("MyTag", exception.message.toString())
        }
        if(newsList.size>0){
            return newsList
        }else{
            newsList=getNewsFromDB()
            newsCacheDataSource.saveNewsToCache(newsList)
        }

        return newsList
    }
}
