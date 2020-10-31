package com.ishan_android.newsapp.presentation.di


import com.ishan_android.newsapp.presentation.di.news.NewsSubComponent

interface Injector {
   fun createNewsSubComponent():NewsSubComponent
}