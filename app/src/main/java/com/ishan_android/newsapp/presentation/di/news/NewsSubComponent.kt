package com.ishan_android.newsapp.presentation.di.news

import com.ishan_android.newsapp.presentation.HomeActivity
import dagger.Subcomponent

@NewsScope
@Subcomponent(modules = [NewsModule::class])
interface NewsSubComponent {
    fun inject(homeActivity: HomeActivity)

    @Subcomponent.Factory
    interface Factory{
        fun create():NewsSubComponent
    }

}

