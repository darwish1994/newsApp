package com.link.newsapp.domain.usecase

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.google.common.truth.Truth
import com.link.newsapp.domain.repo.ArticleRepo
import com.link.newsapp.network.ArticlesCategories
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import dagger.hilt.android.testing.HiltTestApplication
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import javax.inject.Inject

@ExperimentalCoroutinesApi
@HiltAndroidTest
@RunWith(RobolectricTestRunner::class)
@org.robolectric.annotation.Config(application = HiltTestApplication::class)
class ArticleUseCaseTest  {

    @get:Rule
    var instanceTaskExecutor = InstantTaskExecutorRule()

    @get:Rule
    var hiltRule = HiltAndroidRule(this)

    @Inject
    lateinit var articleRepo: ArticleRepo

    @Before
    fun init() {
        hiltRule.inject()
    }


    @Test
    fun `test associated articles`() = runBlocking {

        val result = articleRepo.getArticles(ArticlesCategories.associated_press)

        Truth.assertThat(result.data).isNotNull()
        Truth.assertThat(result.data?.data).isNotEmpty()
    }

    @Test
    fun `test next world articles`() = runBlocking {

        val result = articleRepo.getArticles(ArticlesCategories.associated_press)

        Truth.assertThat(result.data).isNotNull()
        Truth.assertThat(result.data?.data).isNotEmpty()
    }

}