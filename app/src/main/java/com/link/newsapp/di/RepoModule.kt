package com.link.newsapp.di

import com.link.newsapp.data.remote.api.ArticlesApi
import com.link.newsapp.data.repo.ArticleRepoImpl
import com.link.newsapp.domain.repo.ArticleRepo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class RepoModule {
    @Provides
    fun provideArticleRepo(articlesApi: ArticlesApi):ArticleRepo = ArticleRepoImpl(articlesApi)
}