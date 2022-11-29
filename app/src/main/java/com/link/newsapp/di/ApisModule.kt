package com.link.newsapp.di

import com.link.newsapp.data.remote.api.ArticlesApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ApisModule {

    @Provides
    @Singleton
    fun provideArticleApi(retrofit: Retrofit): ArticlesApi =
        retrofit.create(ArticlesApi::class.java)
}