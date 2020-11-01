package com.ishan_android.newsapp.presentation.adapter

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.ishan_android.newsapp.R
import com.ishan_android.newsapp.databinding.NewsSourceListItemBinding
import com.ishan_android.newsapp.model.source.Source
import com.ishan_android.newsapp.presentation.DetailActivity


class NewsSourceAdapter(var context:Context):RecyclerView.Adapter<MyViewHolder>() {
    private val sourceList = ArrayList<Source>()
    lateinit var binding:NewsSourceListItemBinding
    fun setList(artists:List<Source>){
        sourceList.clear()
        sourceList.addAll(artists)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
         binding = DataBindingUtil.inflate(
            layoutInflater,
            R.layout.news_source_list_item,
            parent,
            false
        )
        return MyViewHolder(binding)
    }



    override fun getItemCount(): Int {
        return sourceList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
       holder.bind(sourceList[position])
        binding.listItemLayout.setOnClickListener {
            Log.d("","DATA::::"+sourceList[position])
            var articleId:String = sourceList[position].id
            val intent = Intent (context, DetailActivity::class.java)
            intent.putExtra("ID",articleId)
            context.startActivity(intent)
        }
    }
}



class MyViewHolder(val binding: NewsSourceListItemBinding):
RecyclerView.ViewHolder(binding.root){

   fun bind(source:Source){
        binding.titleTextView.text = source.name
        binding.descriptionTextView.text = source.description

   }

}