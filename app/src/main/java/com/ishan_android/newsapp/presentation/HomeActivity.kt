package com.ishan_android.newsapp.presentation

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import com.ishan_android.newsapp.R
import com.ishan_android.newsapp.presentation.adapter.MyAdapter
import com.ishan_android.newsapp.databinding.ActivityHomeBinding
import com.ishan_android.newsapp.presentation.di.Injector
import com.ishan_android.newsapp.presentation.news.NewsViewModel
import com.ishan_android.newsapp.presentation.news.NewsViewModelFactory
import javax.inject.Inject

class HomeActivity : AppCompatActivity() {
    lateinit var tabLayout: TabLayout
    lateinit var viewPager: ViewPager
    @Inject
    lateinit var factory: NewsViewModelFactory
    private lateinit var newsViewModel: NewsViewModel
    private lateinit var binding:ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_home)
        title = "KotlinApp"
        tabLayout = findViewById(R.id.tabLayout)
        viewPager = findViewById(R.id.viewPager)
        tabLayout.addTab(tabLayout.newTab().setText("Source"))
        tabLayout.addTab(tabLayout.newTab().setText("All News"))
        tabLayout.tabGravity = TabLayout.GRAVITY_FILL
        val adapter = MyAdapter(this, supportFragmentManager,
            tabLayout.tabCount)
        viewPager.adapter = adapter
        viewPager.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tabLayout))
        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                viewPager.currentItem = tab.position
            }
            override fun onTabUnselected(tab: TabLayout.Tab) {}
            override fun onTabReselected(tab: TabLayout.Tab) {}
        })

//        (application as Injector).createNewsSubComponent().inject(this)
//        newsViewModel =ViewModelProvider(this,factory).get(NewsViewModel::class.java)
//        val responseNewsLiveData  = newsViewModel.getNews()
//        responseNewsLiveData.observe(this, Observer {
//            Log.i("MY TAG ",""+it.toString())
//        })

    }
}