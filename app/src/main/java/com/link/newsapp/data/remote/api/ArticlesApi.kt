package com.link.newsapp.data.remote.api

import com.link.newsapp.data.model.Article
import com.link.newsapp.data.remote.response.ResponseWrapper
import com.link.newsapp.network.ArticlesUrl
import retrofit2.http.GET
import retrofit2.http.Query

interface ArticlesApi {

    @GET(ArticlesUrl.articles)
    suspend fun getArticles(@Query("source") query: String):ResponseWrapper<List<Article>>

}