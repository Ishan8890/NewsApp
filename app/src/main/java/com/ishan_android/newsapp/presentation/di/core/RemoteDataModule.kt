package com.ishan_android.newsapp.presentation.di.core

import com.ishan_android.newsapp.data.api.NewsService
import com.ishan_android.newsapp.data.repository.news_source.datasource.NewsRemoteDataSource
import com.ishan_android.newsapp.data.repository.news_source.datasourceImpl.NewsRemoteSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RemoteDataModule(private val apiKey: String) {
    @Singleton
    @Provides
    fun provideNewsRemoteDataSource(newsdbService: NewsService): NewsRemoteDataSource {
        return NewsRemoteSourceImpl(
            newsdbService, apiKey
        )
    }

}