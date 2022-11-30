package com.link.newsapp.data.model

import com.google.gson.annotations.SerializedName

enum class Status {
    @SerializedName("ok")
    OK,
    @SerializedName("error")
    ERROR
}