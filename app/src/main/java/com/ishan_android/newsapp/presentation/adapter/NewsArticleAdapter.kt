package com.ishan_android.newsapp.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.ishan_android.newsapp.R
import com.ishan_android.newsapp.databinding.NewsArticleListItemBinding
import com.ishan_android.newsapp.databinding.NewsSourceListItemBinding
import com.ishan_android.newsapp.model.allnews.Article
import com.ishan_android.newsapp.model.source.Source


class NewsArticleAdapter():RecyclerView.Adapter<ArticleViewHolder>() {
    private val articleList = ArrayList<Article>()

    fun setList(article:List<Article>){
        articleList.clear()
        articleList.addAll(article)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding : NewsArticleListItemBinding = DataBindingUtil.inflate(
                layoutInflater,
                R.layout.news_article_list_item,
                parent,
                false
        )
        return ArticleViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return articleList.size
    }

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        holder.bind(articleList[position])
    }
}



class ArticleViewHolder(val binding: NewsArticleListItemBinding):
        RecyclerView.ViewHolder(binding.root){

    fun bind(article:Article){
        binding.titleTextView.text = article.title
        binding.descriptionTextView.text = article.description
        val posterURL = article.urlToImage
        Glide.with(binding.imageView.context)
            .load(posterURL)
            .into(binding.imageView)

    }

}