package com.ishan_android.newsapp.presentation.di.core

import android.content.Context
import com.ishan_android.newsapp.presentation.di.news.NewsSubComponent
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(subcomponents = [NewsSubComponent::class])
class AppModule(private val context: Context) {

 @Singleton
 @Provides
 fun provideApplicationContext():Context{
     return context.applicationContext
 }

}