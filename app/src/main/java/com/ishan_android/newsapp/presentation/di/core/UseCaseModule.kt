package com.ishan_android.newsapp.presentation.di.core

import com.ishan_android.newsapp.domain.repository.NewsRepository
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

}