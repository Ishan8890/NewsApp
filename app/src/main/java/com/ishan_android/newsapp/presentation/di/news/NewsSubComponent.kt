package com.ishan_android.newsapp.presentation.di.news

import com.ishan_android.newsapp.fragment.AllNewsFragment
import com.ishan_android.newsapp.fragment.SourceFragment
import com.ishan_android.newsapp.presentation.DetailActivity
import com.ishan_android.newsapp.presentation.HomeActivity
import dagger.Subcomponent

@NewsScope
@Subcomponent(modules = [NewsModule::class])
interface NewsSubComponent {
    fun inject(homeActivity: HomeActivity)
    fun inject(sourceFragment: SourceFragment)
    fun inject(allNewsFragment: AllNewsFragment)
    fun inject(detailActivity: DetailActivity)

    @Subcomponent.Factory
    interface Factory{
        fun create():NewsSubComponent
    }

}

