package com.link.newsapp.presenter.details

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.link.newsapp.R
import com.link.newsapp.common.extention.convertDateToString
import com.link.newsapp.common.extention.loadImage
import com.link.newsapp.common.extention.navTo
import com.link.newsapp.common.extention.viewBinding
import com.link.newsapp.databinding.FragmentDetailsBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailsFragment : Fragment(R.layout.fragment_details) {
    private val args by navArgs<DetailsFragmentArgs>()
    private val binding by viewBinding(FragmentDetailsBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        args.article.let { article ->
            binding.apply {

                tvTitle.text = article.title
                tvCreator.text = article.author
                tvDate.text = article.publishedAt?.convertDateToString()
                tvDetails.text = article.description
                article.urlToImage?.let { imNews.loadImage(it) }


                // click browser
                btnBrowser.setOnClickListener {
                    article.url?.let { url ->
                        navTo(DetailsFragmentDirections.actionDetailsFragmentToBrowserFragment(url))

                    }

                }

            }
        }


    }

}
