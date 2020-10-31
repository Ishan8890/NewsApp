package com.ishan_android.newsapp.model.source


import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

@Keep
data class SourceModel(
    var sources: List<Source>,
    var status: String
)