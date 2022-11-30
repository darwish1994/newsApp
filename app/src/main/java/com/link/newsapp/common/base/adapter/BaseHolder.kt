package com.link.newsapp.common.base.adapter

import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding

abstract class BaseHolder<T,VB:ViewBinding>(container:VB) :RecyclerView.ViewHolder(container.root) {
    abstract fun bind(item:T)
}