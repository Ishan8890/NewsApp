package com.ishan_android.newsapp.domain.usecase

import com.ishan_android.newsapp.domain.repository.NewsRepository
import com.ishan_android.newsapp.model.allnews.Article


class GetDetailNewsUseCase(private val newsRepository: NewsRepository) {
    suspend fun execute(id:String):List<Article>? {
        return newsRepository.getDetailSource(id)
    }
}