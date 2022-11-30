package com.link.newsapp.presenter.home

import androidx.fragment.app.Fragment
import com.link.newsapp.R
import com.link.newsapp.common.extention.viewBinding
import com.link.newsapp.databinding.FragmentArticleBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class ArticleFragment : Fragment(R.layout.fragment_article){
    private val binding by viewBinding(FragmentArticleBinding::bind)


}