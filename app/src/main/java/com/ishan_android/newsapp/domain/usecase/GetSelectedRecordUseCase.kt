package com.ishan_android.newsapp.domain.usecase

import com.ishan_android.newsapp.domain.repository.NewsRepository
import com.ishan_android.newsapp.model.source.Source

class GetSelectedRecordUseCase(private val newsRepository: NewsRepository) {
    suspend fun execute(limit:Int,offset:Int): List<Source>? = newsRepository.getSelectedDbSource(limit,offset)
}