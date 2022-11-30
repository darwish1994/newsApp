package com.link.newsapp.common.extention

import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.request.RequestOptions
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
        .error(R.drawable.placeholder)
        .placeholder(R.drawable.placeholder)
        .transition(DrawableTransitionOptions.withCrossFade())
        .apply(RequestOptions.centerCropTransform())
        .into(this)
}