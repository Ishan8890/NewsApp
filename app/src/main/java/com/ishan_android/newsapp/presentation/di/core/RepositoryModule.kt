package com.ishan_android.newsapp.presentation.di.core

import com.ishan_android.newsapp.data.repository.news_source.NewsRespositoryImpl
import com.ishan_android.newsapp.data.repository.news_source.datasource.NewsCacheDataSource
import com.ishan_android.newsapp.data.repository.news_source.datasource.NewsLocalDataSource
import com.ishan_android.newsapp.data.repository.news_source.datasource.NewsRemoteDataSource
import com.ishan_android.newsapp.domain.repository.NewsRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Provides
    @Singleton
    fun provideMovieRepository(
        newsRemoteDatasource: NewsRemoteDataSource,
        newsLocalDataSource: NewsLocalDataSource,
        newsCacheDataSource: NewsCacheDataSource
    ): NewsRepository {

        return NewsRespositoryImpl(
            newsCacheDataSource,
            newsLocalDataSource,
            newsRemoteDatasource
        )
    }

}