package com.link.newsapp.di

import com.link.newsapp.data.remote.api.ArticlesApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import retrofit2.Retrofit

@Module
@InstallIn(ViewModelComponent::class)
class ApisModule {

    @Provides
    fun provideArticleApi(retrofit: Retrofit): ArticlesApi =
        retrofit.create(ArticlesApi::class.java)
}