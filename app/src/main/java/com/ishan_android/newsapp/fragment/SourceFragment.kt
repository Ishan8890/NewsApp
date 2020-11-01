package com.ishan_android.newsapp.fragment

import android.R.attr.data
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.ishan_android.newsapp.R
import com.ishan_android.newsapp.databinding.FragmentSourcesBinding
import com.ishan_android.newsapp.presentation.adapter.NewsSourceAdapter
import com.ishan_android.newsapp.presentation.di.Injector
import com.ishan_android.newsapp.presentation.news.NewsViewModel
import com.ishan_android.newsapp.presentation.news.NewsViewModelFactory
import javax.inject.Inject


class SourceFragment : Fragment() {

   @Inject
   lateinit var factory: NewsViewModelFactory
   private lateinit var newsViewModel: NewsViewModel
   private lateinit var adapter: NewsSourceAdapter

   override fun onCreateView(
           inflater: LayoutInflater, container: ViewGroup?,
           savedInstanceState: Bundle?
   ): View? {
      val binding: FragmentSourcesBinding = DataBindingUtil.inflate(
              inflater, R.layout.fragment_sources, container, false)
      val view: View = binding.getRoot()
      (activity!!.application as Injector).createNewsSubComponent().inject(this)

      newsViewModel= ViewModelProvider(this,factory)
              .get(NewsViewModel::class.java)
      initRecyclerView(binding)
      return view
   }

   private fun initRecyclerView(binding:FragmentSourcesBinding){
      binding.sourceRecyclerView.layoutManager = LinearLayoutManager(activity)
      adapter = NewsSourceAdapter(context!!)
      binding.sourceRecyclerView.adapter = adapter
      displayNewsSource(binding)
      binding.itemsswipetorefresh.setOnRefreshListener {
         updateNewsSource(binding)
      }
   }

   private fun updateNewsSource(binding:FragmentSourcesBinding){
      val responseLiveData = newsViewModel.updateNews()
      responseLiveData.observe(this, Observer {
         if(it!=null){
            binding.itemsswipetorefresh.isRefreshing = false
            adapter.setList(it)
            adapter.notifyDataSetChanged()
//            binding.sourceProgressBar.visibility = View.GONE
         }else{
            binding.itemsswipetorefresh.isRefreshing = false
//            binding.sourceProgressBar.visibility = View.GONE
            Toast.makeText(activity,"No data available", Toast.LENGTH_LONG).show()
         }
      })
   }

   private fun displayNewsSource(binding:FragmentSourcesBinding){
      binding.sourceProgressBar.visibility = View.VISIBLE
      binding.itemsswipetorefresh.visibility = View.GONE
      val responseLiveData = newsViewModel.getNews()
      responseLiveData.observe(this, Observer {
         if(it!=null){
            adapter.setList(it)
            adapter.notifyDataSetChanged()
            binding.itemsswipetorefresh.visibility = View.VISIBLE
            binding.sourceProgressBar.visibility = View.GONE
         }else{
            binding.sourceProgressBar.visibility = View.GONE
            binding.itemsswipetorefresh.visibility = View.GONE
            Toast.makeText(activity,"No data available", Toast.LENGTH_LONG).show()
         }
      })
   }
}