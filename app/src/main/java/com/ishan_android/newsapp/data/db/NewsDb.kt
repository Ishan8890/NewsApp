package com.ishan_android.newsapp.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.ishan_android.newsapp.model.source.Source

@Database(entities = [Source::class],
    version = 1,
    exportSchema = false
)
abstract class NewsDb : RoomDatabase(){
    abstract fun newsDao(): SourceNewsDao
}