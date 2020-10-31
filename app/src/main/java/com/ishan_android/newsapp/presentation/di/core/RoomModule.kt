package com.ishan_android.newsapp.presentation.di.core

import android.content.Context
import androidx.room.Room
import com.ishan_android.newsapp.data.db.NewsDb
import com.ishan_android.newsapp.data.db.SourceNewsDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RoomModule {

    @Singleton
    @Provides
    fun provideRoomDb(context:Context):NewsDb{
        return Room.databaseBuilder(context,NewsDb::class.java,"newsdb")
            .build()
    }

    @Singleton
    @Provides
    fun provideNewsDao(newDb: NewsDb): SourceNewsDao {
        return newDb.newsDao()
    }
}