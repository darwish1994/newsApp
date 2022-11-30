package com.link.newsapp.presenter.article

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.link.newsapp.common.SingleLiveEvent
import com.link.newsapp.data.model.Article
import com.link.newsapp.data.remote.response.ResponseWrapper
import com.link.newsapp.domain.usecase.ArticleUseCase
import com.link.newsapp.network.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class ArticleViewModel @Inject constructor(
    private val articleUseCase: ArticleUseCase,
) : ViewModel() {
    private val articleLiveData by lazy { SingleLiveEvent<Resource<ResponseWrapper<List<Article>>>>() }

    fun getArticleLiveData(): LiveData<Resource<ResponseWrapper<List<Article>>>> = articleLiveData

    fun getArticles() {
        articleUseCase.invoke().onEach {
            articleLiveData.value = it
        }.launchIn(viewModelScope)

    }

}