package com.ishan_android.newsapp.presentation.news

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.ishan_android.newsapp.domain.usecase.*

class NewsViewModel(
    private val getNewsUseCase: GetNewsUseCase,
    private val updateNewsUseCase: UpdateNewsUseCase,
    private val getArticleUseCase: GetArticleUseCase,
    private val getDetailNewsUseCase: GetDetailNewsUseCase,
    private val getSelectedRecordUseCase: GetSelectedRecordUseCase
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
    fun getSelectedNews(limit:Int,offset:Int)= liveData {
        val sourceList =  getSelectedRecordUseCase.execute(limit,offset)
        emit(sourceList)
    }

}