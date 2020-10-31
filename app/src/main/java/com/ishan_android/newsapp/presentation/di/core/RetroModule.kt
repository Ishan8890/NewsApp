package com.ishan_android.newsapp.presentation.di.core

import com.ishan_android.newsapp.data.api.NewsService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class RetroModule(private val baseURL:String) {

    @Singleton
    @Provides
    fun provideRetrofit():Retrofit{
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(baseURL)
            .build()

    }

    @Singleton
    @Provides
    fun getNewsService(retrofit: Retrofit):NewsService{
        return retrofit.create(NewsService::class.java)
    }
}