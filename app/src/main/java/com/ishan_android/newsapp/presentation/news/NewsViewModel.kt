package com.ishan_android.newsapp.presentation.news

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.ishan_android.newsapp.domain.usecase.GetArticleUseCase
import com.ishan_android.newsapp.domain.usecase.GetDetailNewsUseCase
import com.ishan_android.newsapp.domain.usecase.GetNewsUseCase
import com.ishan_android.newsapp.domain.usecase.UpdateNewsUseCase

class NewsViewModel(
    private val getNewsUseCase: GetNewsUseCase,
    private val updateNewsUseCase: UpdateNewsUseCase,
    private val getArticleUseCase: GetArticleUseCase,
    private val getDetailNewsUseCase: GetDetailNewsUseCase
): ViewModel() {

    fun getNews() = liveData {
        val artistList = getNewsUseCase.execute()
        emit(artistList)
    }

    fun updateNews() = liveData {
        val artistList = updateNewsUseCase.execute()
        emit(artistList)
    }
    fun getHeadlines() = liveData {
        val articleList =getArticleUseCase.execute()
        emit(articleList)
    }
    fun getDetailNews(id:String) = liveData {
        val articleList =getDetailNewsUseCase.execute(id)
        emit(articleList)
    }

}