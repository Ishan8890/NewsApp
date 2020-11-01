package com.ishan_android.newsapp.domain.usecase

import com.ishan_android.newsapp.domain.repository.NewsRepository
import com.ishan_android.newsapp.model.allnews.Article
import com.ishan_android.newsapp.model.source.Source

class GetArticleUseCase(private val newsRepository: NewsRepository) {
    suspend fun execute():List<Article>? = newsRepository.getArticleSource()
}