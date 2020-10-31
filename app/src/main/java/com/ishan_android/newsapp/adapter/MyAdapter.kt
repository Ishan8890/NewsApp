package com.ishan_android.newsapp.adapter

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.ishan_android.newsapp.fragment.AllNews
import com.ishan_android.newsapp.fragment.Sources

@Suppress("DEPRECATION")
internal class MyAdapter(
   var context: Context,
   fm: FragmentManager,
   var totalTabs: Int
) :
FragmentPagerAdapter(fm) {
   override fun getItem(position: Int): Fragment {
      return when (position) {
         0 -> {
            Sources()
         }
         1 -> {
            AllNews()
         }
         else -> getItem(position)
      }
   }
   override fun getCount(): Int {
      return totalTabs
   }
}