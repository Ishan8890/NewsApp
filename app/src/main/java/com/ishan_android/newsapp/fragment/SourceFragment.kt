package com.ishan_android.newsapp.fragment

import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ishan_android.newsapp.R
import com.ishan_android.newsapp.databinding.FragmentSourcesBinding
import com.ishan_android.newsapp.model.source.Source
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
   private var isLoading:Boolean = false
   private var currentPage = 0
   private var isLastPage = false
   lateinit var binding: FragmentSourcesBinding
   lateinit var layoutManager:LinearLayoutManager
//   var arrayList:ArrayList<Source?> = ArrayList()
   private var isFirst_Loading = false
   var page:Int = 0
   companion object {
      var arrayList = ArrayList<Source?>()
      val pageSize:Int = 10
   }

   override fun onCreateView(
           inflater: LayoutInflater, container: ViewGroup?,
           savedInstanceState: Bundle?
   ): View? {
      binding = DataBindingUtil.inflate(
              inflater, R.layout.fragment_sources, container, false
      )
      val view: View = binding.getRoot()
      (activity!!.application as Injector).createNewsSubComponent().inject(this)

      newsViewModel= ViewModelProvider(this, factory)
              .get(NewsViewModel::class.java)
      initRecyclerView(binding)

      return view
   }

   private fun initRecyclerView(binding: FragmentSourcesBinding){
      layoutManager = LinearLayoutManager(activity)
//      binding.sourceRecyclerView.layoutManager = LinearLayoutManager(activity)
      binding.sourceRecyclerView.layoutManager = layoutManager
      adapter = NewsSourceAdapter(context!!)
      binding.sourceRecyclerView.adapter = adapter
      displayNewsSource()
      binding.itemsswipetorefresh.setOnRefreshListener {
         page = 0
         arrayList.clear()
         adapter.clearData()
         updateNewsSource()
      }
   }

   fun initScrollListener(){

      binding.sourceRecyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
         override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
            super.onScrollStateChanged(recyclerView, newState)
         }


         override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
            super.onScrolled(recyclerView, dx, dy)
            val linearLayoutManager = recyclerView.layoutManager as LinearLayoutManager?
            if (!isLoading) {

               val visibleItemCount: Int = recyclerView.layoutManager!!.getChildCount()
               val totalItemCount: Int = recyclerView.layoutManager!!.getItemCount()
               val firstVisibleItemPosition: Int = (recyclerView.layoutManager as LinearLayoutManager).findFirstVisibleItemPosition()

               if(linearLayoutManager!!.findLastCompletelyVisibleItemPosition()!=-1)
               if (linearLayoutManager != null && linearLayoutManager.findLastCompletelyVisibleItemPosition() == arrayList.size - 1) {
                  //bottom of list!
                  loadMore(arrayList)
                  isLoading = true
               }

            }
         }
      })
   }

   private fun loadMore(rowsArrayList:ArrayList<Source?>) {
      rowsArrayList.add(null)
      adapter.notifyItemInserted(rowsArrayList.size - 1)

      rowsArrayList.removeAt(rowsArrayList.size - 1)
      val scrollPosition: Int = rowsArrayList.size
      adapter.notifyItemRemoved(scrollPosition)
      var currentSize = scrollPosition
      var nextLimit = currentSize + 10
      val responseLiveData = newsViewModel.getSelectedNews(nextLimit, pageSize)
      responseLiveData.observe(this, Observer {
         if (it != null) {
            arrayList.addAll(it)
            adapter.setList(it)
            adapter.notifyDataSetChanged()
            isLoading = false
         }
      })

//      val handler = Handler()
//      handler.postDelayed({
//
//      }, 2000)
   }

   private fun updateNewsSource(){
      val responseLiveData = newsViewModel.updateNews()
      responseLiveData.observe(this, Observer {
         if (it != null) {
            binding.itemsswipetorefresh.isRefreshing = false
            displaySelectedNews()
//            adapter.setList(it)
//            adapter.notifyDataSetChanged()
//            binding.sourceProgressBar.visibility = View.GONE
         } else {
            binding.itemsswipetorefresh.isRefreshing = false
//            binding.sourceProgressBar.visibility = View.GONE
            Toast.makeText(activity, "No data available", Toast.LENGTH_LONG).show()
         }
      })
   }

   private fun displayNewsSource(){
      binding.sourceProgressBar.visibility = View.VISIBLE
      binding.itemsswipetorefresh.visibility = View.GONE
      val responseLiveData = newsViewModel.getNews()
      responseLiveData.observe(this, Observer {
         if (it != null) {
            if (it.size > 0) {
               displaySelectedNews()
            }
            binding.itemsswipetorefresh.visibility = View.VISIBLE
            binding.sourceProgressBar.visibility = View.GONE
         } else {
            binding.sourceProgressBar.visibility = View.GONE
            binding.itemsswipetorefresh.visibility = View.GONE
            Toast.makeText(activity, "No data available", Toast.LENGTH_LONG).show()
         }
      })
   }
   private fun displaySelectedNews(){
      isFirst_Loading = true;
      val responseLiveData = newsViewModel.getSelectedNews(page, pageSize)
      responseLiveData.observe(this, Observer {
         if (it != null) {
            arrayList.addAll(it)
            adapter.setList(it)

            initScrollListener()
            adapter.notifyDataSetChanged()
         }
      })
   }

}