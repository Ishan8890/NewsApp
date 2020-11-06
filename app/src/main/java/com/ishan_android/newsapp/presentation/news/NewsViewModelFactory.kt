package com.ishan_android.newsapp.presentation.news

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.ishan_android.newsapp.domain.usecase.*

class NewsViewModelFactory(
    private val getNewsUseCase: GetNewsUseCase,
    private val updateNewsUseCase: UpdateNewsUseCase,
    private val getArticleUseCase: GetArticleUseCase,
    private val getDetailNewsUseCase: GetDetailNewsUseCase,
    private val getSelectedRecordUseCase: GetSelectedRecordUseCase
): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return NewsViewModel(
            getNewsUseCase,
            updateNewsUseCase,
            getArticleUseCase,
            getDetailNewsUseCase,
            getSelectedRecordUseCase
        ) as T
    }
}