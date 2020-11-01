package com.ishan_android.newsapp.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.ishan_android.newsapp.R
import com.ishan_android.newsapp.databinding.ActivityDetailBinding
import com.ishan_android.newsapp.databinding.FragmentAllNewsBinding
import com.ishan_android.newsapp.presentation.adapter.NewsArticleAdapter
import com.ishan_android.newsapp.presentation.di.Injector
import com.ishan_android.newsapp.presentation.news.NewsViewModel
import com.ishan_android.newsapp.presentation.news.NewsViewModelFactory
import javax.inject.Inject

class DetailActivity : AppCompatActivity() {
    @Inject
    lateinit var factory: NewsViewModelFactory
    private lateinit var newsViewModel: NewsViewModel
    private lateinit var adapter: NewsArticleAdapter
    private lateinit var binding:ActivityDetailBinding
    private lateinit var articleId:String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        articleId = intent.getStringExtra("ID")
        binding = DataBindingUtil.setContentView(this, R.layout.activity_detail)
        (application as Injector).createNewsSubComponent().inject(this)
        newsViewModel= ViewModelProvider(this,factory)
            .get(NewsViewModel::class.java)
        initRecyclerView(binding)
    }
    private fun initRecyclerView(binding: ActivityDetailBinding){
        binding.detailRecyclerView.layoutManager = LinearLayoutManager(this)
        adapter = NewsArticleAdapter()
        binding.detailRecyclerView.adapter = adapter
        displayNewsSource(binding)
    }

    private fun displayNewsSource(binding: ActivityDetailBinding){
        binding.detailRecyclerView.visibility = View.VISIBLE
        val responseLiveData = newsViewModel.getDetailNews(articleId)
        responseLiveData.observe(this, Observer {
            if(it!=null){
                adapter.setList(it)
                adapter.notifyDataSetChanged()
                binding.detailProgressBar.visibility = View.GONE
            }else{
                binding.detailProgressBar.visibility = View.GONE
                Toast.makeText(this,"No data available", Toast.LENGTH_LONG).show()
            }
        })
    }
}