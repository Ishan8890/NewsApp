package com.ishan_android.newsapp.presentation

import android.app.Application
import com.ishan_android.newsapp.BuildConfig
import com.ishan_android.newsapp.presentation.di.Injector
import com.ishan_android.newsapp.presentation.di.core.*
import com.ishan_android.newsapp.presentation.di.news.NewsSubComponent
import javax.inject.Inject

class App : Application(), Injector {
private lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(applicationContext))
            .retroModule(RetroModule(BuildConfig.BASE_URL))
            .remoteDataModule(RemoteDataModule(BuildConfig.API_KEY))
            .build()

    }

    override fun createNewsSubComponent(): NewsSubComponent {
        return appComponent.newsSubComponent().create()
    }


}