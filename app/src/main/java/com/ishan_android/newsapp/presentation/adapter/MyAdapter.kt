package com.ishan_android.newsapp.presentation.adapter

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.ishan_android.newsapp.fragment.AllNewsFragment
import com.ishan_android.newsapp.fragment.SourceFragment

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
            SourceFragment()
         }
         1 -> {
            AllNewsFragment()
         }
         else -> getItem(position)
      }
   }
   override fun getCount(): Int {
      return totalTabs
   }
}