package com.link.newsapp.data.repo

import com.link.newsapp.data.model.Article
import com.link.newsapp.data.remote.api.ArticlesApi
import com.link.newsapp.data.remote.response.ResponseWrapper
import com.link.newsapp.domain.repo.ArticleRepo
import com.link.newsapp.network.NetworkRemoteServiceCall
import com.link.newsapp.network.Resource
import javax.inject.Inject

class ArticleRepoImpl @Inject constructor(private val articlesApi: ArticlesApi) : ArticleRepo,
    NetworkRemoteServiceCall {
    override suspend fun getArticles(category: String): Resource<ResponseWrapper<List<Article>>> =
        safeApiCallGeneric {
            articlesApi.getArticles(category)
        }
}