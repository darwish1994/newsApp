package com.link.newsapp.data.remote.response

import com.google.gson.annotations.SerializedName
import com.link.newsapp.data.model.Status

data class ResponseWrapper<T>(
    val status: Status,
    @SerializedName("articles")
    val data:T?,
    val message:String?=""
)
