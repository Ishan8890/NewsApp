package com.ishan_android.newsapp.presentation.news

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.ishan_android.newsapp.domain.usecase.GetArticleUseCase
import com.ishan_android.newsapp.domain.usecase.GetDetailNewsUseCase
import com.ishan_android.newsapp.domain.usecase.GetNewsUseCase
import com.ishan_android.newsapp.domain.usecase.UpdateNewsUseCase

class NewsViewModelFactory(
    private val getNewsUseCase: GetNewsUseCase,
    private val updateNewsUseCase: UpdateNewsUseCase,
    private val getArticleUseCase: GetArticleUseCase,
    private val getDetailNewsUseCase: GetDetailNewsUseCase
): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return NewsViewModel(
            getNewsUseCase,
            updateNewsUseCase,
            getArticleUseCase,
            getDetailNewsUseCase
        ) as T
    }
}