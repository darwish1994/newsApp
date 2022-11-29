package com.link.newsapp.domain.usecase

import com.link.newsapp.domain.repo.ArticleRepo
import com.link.newsapp.network.ArticlesCategories
import com.link.newsapp.network.Resource
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetNextWebUseCase @Inject constructor(private val articleRepo: ArticleRepo) {

    operator fun invoke() = flow {
        emit(Resource.Loading())
        emit(articleRepo.getArticles(ArticlesCategories.next_web))
    }
}