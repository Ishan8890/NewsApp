package com.ishan_android.newsapp.domain.repository

import com.ishan_android.newsapp.model.allnews.Article
import com.ishan_android.newsapp.model.source.Source

interface NewsRepository {
    suspend fun getNewsSource():List<Source>?
    suspend fun updateNewsSource():List<Source>?
    suspend fun getArticleSource():List<Article>?
    suspend fun getDetailSource(id:String):List<Article>?
    suspend fun getSelectedDbSource(limit:Int,offset:Int):List<Source>?
}