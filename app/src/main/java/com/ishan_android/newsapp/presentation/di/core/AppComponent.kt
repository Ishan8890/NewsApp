package com.ishan_android.newsapp.presentation.di.core

import com.ishan_android.newsapp.presentation.di.news.NewsSubComponent
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules=[RetroModule::class,
    RoomModule::class,
    AppModule::class,
    UseCaseModule::class,
    RepositoryModule::class,
    RemoteDataModule::class,
    LocalDataModule::class,
    CacheDataModule::class])
interface AppComponent {
    fun newsSubComponent(): NewsSubComponent.Factory
}