package com.ishan_android.newsapp.presentation.di.news

import com.ishan_android.newsapp.domain.usecase.GetNewsUseCase
import com.ishan_android.newsapp.domain.usecase.UpdateNewsUseCase
import com.ishan_android.newsapp.presentation.news.NewsViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class NewsModule {
    @NewsScope
    @Provides
    fun provideNewsViewModelFactory(
        getNewsUseCase: GetNewsUseCase,
        updateNewsUseCase: UpdateNewsUseCase
    ): NewsViewModelFactory {
        return NewsViewModelFactory(
            getNewsUseCase,
            updateNewsUseCase
        )
    }

}