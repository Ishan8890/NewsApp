package com.ishan_android.newsapp.presentation.di.core

import com.ishan_android.newsapp.data.db.SourceNewsDao
import com.ishan_android.newsapp.data.repository.news_source.datasource.NewsLocalDataSource
import com.ishan_android.newsapp.data.repository.news_source.datasourceImpl.NewsLocalDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class LocalDataModule {

    @Singleton
    @Provides
    fun provideNewsLocalDataSource(sourceNewsDao: SourceNewsDao):NewsLocalDataSource{
        return NewsLocalDataSourceImpl(sourceNewsDao)
    }
}