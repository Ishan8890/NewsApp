package com.ishan_android.newsapp.presentation.di.core

import com.ishan_android.newsapp.data.repository.news_source.datasource.NewsCacheDataSource
import com.ishan_android.newsapp.data.repository.news_source.datasourceImpl.NewsCacheDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class CacheDataModule {
    @Singleton
    @Provides
    fun provideNewsCacheDataSource(): NewsCacheDataSource {
        return NewsCacheDataSourceImpl()
    }

}