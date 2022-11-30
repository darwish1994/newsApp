package com.link.newsapp.common.extention

import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import com.bumptech.glide.Glide
import com.link.newsapp.R
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

fun ImageView.loadImage(url:String){
    Glide.with(this).load(url)
        .error(R.drawable.gallery)
        .into(this)
}