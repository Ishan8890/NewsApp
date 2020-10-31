package com.ishan_android.newsapp.model.allnews


import androidx.room.Entity
import com.google.gson.annotations.SerializedName

@Entity(tableName = "all_news_tb")
data class Article(
    val author: String,
    val content: String,
    val description: String,
    val publishedAt: String,
    val source: Source,
    val title: String,
    val url: String,
    val urlToImage: String
)