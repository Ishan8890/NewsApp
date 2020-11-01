package com.ishan_android.newsapp.presentation.di.core

import com.ishan_android.newsapp.domain.repository.NewsRepository
import com.ishan_android.newsapp.domain.usecase.GetArticleUseCase
import com.ishan_android.newsapp.domain.usecase.GetDetailNewsUseCase
import com.ishan_android.newsapp.domain.usecase.GetNewsUseCase
import com.ishan_android.newsapp.domain.usecase.UpdateNewsUseCase
import dagger.Module
import dagger.Provides

@Module
class UseCaseModule {

    @Provides
    fun provideGetNewsUseCase(newsRepository: NewsRepository):GetNewsUseCase{
        return GetNewsUseCase(newsRepository)
    }
    @Provides
    fun provideUpdateNewsUseCase(newsRepository: NewsRepository):UpdateNewsUseCase{
        return UpdateNewsUseCase(newsRepository)
    }
    @Provides
    fun provideGetArticleUseCase(newsRepository: NewsRepository):GetArticleUseCase{
        return GetArticleUseCase(newsRepository)
    }
    @Provides
    fun provideGetDetailUseCase(newsRepository: NewsRepository):GetDetailNewsUseCase{
        return GetDetailNewsUseCase(newsRepository)
    }

}