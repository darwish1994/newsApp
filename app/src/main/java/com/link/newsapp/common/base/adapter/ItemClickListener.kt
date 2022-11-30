package com.link.newsapp.common.base.adapter

interface ItemClickListener {
    fun <T> onItemClicked(item: T)
}