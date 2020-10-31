package com.ishan_android.newsapp.data.repository.news_source.datasourceImpl

import com.ishan_android.newsapp.data.repository.news_source.datasource.NewsCacheDataSource
import com.ishan_android.newsapp.model.source.Source

class NewsCacheDataSourceImpl : NewsCacheDataSource {

    private var artistList = ArrayList<Source>()

    override suspend fun getNewsFromCache(): List<Source> {
        return artistList
    }

    override suspend fun saveNewsToCache(artists: List<Source>) {

        artistList.clear()
        artistList = ArrayList(artists)
    }
}