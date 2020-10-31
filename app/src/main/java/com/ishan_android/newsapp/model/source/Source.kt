package com.ishan_android.newsapp.model.source


import com.google.gson.annotations.SerializedName
import androidx.annotation.Keep
import androidx.room.Entity
import androidx.room.PrimaryKey

@Keep
@Entity(tableName = "news_sources_tb")
data class Source(
    var category: String,
    var country: String,
    var description: String,
    @PrimaryKey
    var id: String,
    var language: String,
    var name: String,
    var url: String
)