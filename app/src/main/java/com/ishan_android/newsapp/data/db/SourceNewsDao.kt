package com.ishan_android.newsapp.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.ishan_android.newsapp.model.source.Source


@Dao
interface SourceNewsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveNews(artists : List<Source>)

    @Query("DELETE FROM news_sources_tb")
    suspend fun deleteAllNews()

    @Query("SELECT * FROM news_sources_tb")
    suspend fun getNews():List<Source>
}