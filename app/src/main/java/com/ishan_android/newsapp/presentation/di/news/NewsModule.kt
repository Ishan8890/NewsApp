package com.ishan_android.newsapp.presentation.di.news

import com.ishan_android.newsapp.domain.usecase.GetArticleUseCase
import com.ishan_android.newsapp.domain.usecase.GetDetailNewsUseCase
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
        updateNewsUseCase: UpdateNewsUseCase,
        getArticleUseCase: GetArticleUseCase,
        getDetailNewsUseCase: GetDetailNewsUseCase
    ): NewsViewModelFactory {
        return NewsViewModelFactory(
            getNewsUseCase,
            updateNewsUseCase,
            getArticleUseCase,
            getDetailNewsUseCase
        )
    }

}