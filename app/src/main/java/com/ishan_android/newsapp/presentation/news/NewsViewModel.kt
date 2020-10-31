package com.ishan_android.newsapp.presentation.news

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.ishan_android.newsapp.domain.usecase.GetNewsUseCase
import com.ishan_android.newsapp.domain.usecase.UpdateNewsUseCase

class NewsViewModel(
    private val getNewsUseCase: GetNewsUseCase,
    private val updateNewsUseCase: UpdateNewsUseCase
): ViewModel() {

    fun getNews() = liveData {
        val artistList = getNewsUseCase.execute()
        emit(artistList)
    }

    fun updateNews() = liveData {
        val artistList = updateNewsUseCase.execute()
        emit(artistList)
    }

}