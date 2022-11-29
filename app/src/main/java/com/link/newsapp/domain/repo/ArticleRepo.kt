package com.link.newsapp.domain.repo

import com.link.newsapp.data.model.Article
import com.link.newsapp.data.remote.response.ResponseWrapper
import com.link.newsapp.network.Resource

interface ArticleRepo {

    suspend fun getArticles(category:String): Resource<ResponseWrapper<List<Article>>>

}