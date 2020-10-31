package com.ishan_android.newsapp.domain.repository

import com.ishan_android.newsapp.model.source.Source

interface NewsRepository {
    suspend fun getNewsSource():List<Source>?
    suspend fun updateNewsSource():List<Source>?
}