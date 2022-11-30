package com.link.newsapp.presenter.article

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.link.newsapp.R
import com.link.newsapp.common.dialog_util.DialogUtil
import com.link.newsapp.common.extention.loading
import com.link.newsapp.common.extention.observe
import com.link.newsapp.common.extention.viewBinding
import com.link.newsapp.data.model.Article
import com.link.newsapp.data.model.Status
import com.link.newsapp.data.remote.response.ResponseWrapper
import com.link.newsapp.databinding.DialogErrorViewBinding
import com.link.newsapp.databinding.FragmentArticleBinding
import com.link.newsapp.network.Resource
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class ArticleFragment : Fragment(R.layout.fragment_article) {
    private val binding by viewBinding(FragmentArticleBinding::bind)
    private val viewModel by viewModels<ArticleViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loadArticles()

    }

    private fun loadArticles() {
        if (!viewModel.getArticleLiveData().hasActiveObservers())
            observe(viewModel.getArticleLiveData(), ::articleObserver)
    }

    private fun articleObserver(it: Resource<ResponseWrapper<List<Article>>>?) = it?.let {
        binding.progress.loading(it)
        when (it) {
            is Resource.Success -> {
                if (it.data?.status == Status.OK) {
                    // todo append data in adapter

                } else {
                    it.data?.message?.let { it1 -> showError(it1) }
                }
            }

            is Resource.Error -> showError(
                it.message ?: it.exception?.message ?: getString(R.string.somthing_wrong)
            )


            else -> Unit
        }

    }


    private fun showError(msg: String) {
        DialogUtil.showErrorDialog(
            context = requireActivity(),
            view = DialogErrorViewBinding.inflate(layoutInflater),
            message = msg,
            retry = {
                loadArticles()
            },
            cancel = {},
        )
    }
}