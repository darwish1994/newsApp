package com.link.newsapp.common.extention

import android.view.View
import android.widget.ProgressBar
import com.link.newsapp.network.Resource

fun View.toVisible() {
    visibility = View.VISIBLE
}

fun View.toGone() {
    visibility = View.GONE
}

fun ProgressBar.loading(status: Resource<*>) {
    if (status is Resource.Loading)
        toVisible()
    else
        toGone()
}