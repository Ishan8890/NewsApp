package com.ishan_android.newsapp.model.allnews


import com.google.gson.annotations.SerializedName

data class everything_news_model(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)