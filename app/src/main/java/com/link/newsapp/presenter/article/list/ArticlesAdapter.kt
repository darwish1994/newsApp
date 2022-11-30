package com.link.newsapp.presenter.article.list

import android.view.LayoutInflater
import android.view.ViewGroup
import com.link.newsapp.common.base.adapter.BaseHolder
import com.link.newsapp.common.base.adapter.GeneralListAdapter
import com.link.newsapp.common.extention.convertDateToString
import com.link.newsapp.common.extention.loadImage
import com.link.newsapp.data.model.Article
import com.link.newsapp.databinding.ItemLayoutNewsBinding

class ArticlesAdapter : GeneralListAdapter<Article, ItemLayoutNewsBinding>() {


    inner class ArticlesViewHolder(private val container: ItemLayoutNewsBinding) :
        BaseHolder<Article, ItemLayoutNewsBinding>(container) {
        override fun bind(item: Article) {
            container.apply {
                tvTitle.text = item.title
                tvCreator.text = item.author
                tvDate.text = item.publishedAt?.convertDateToString()
                item.urlToImage?.let { imNews.loadImage(it) }
            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BaseHolder<Article, ItemLayoutNewsBinding> = ArticlesViewHolder(
        ItemLayoutNewsBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
    )
}