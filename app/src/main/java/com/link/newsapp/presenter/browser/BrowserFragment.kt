package com.link.newsapp.presenter.browser

import android.os.Bundle
import android.view.View
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.link.newsapp.R
import com.link.newsapp.common.extention.viewBinding
import com.link.newsapp.databinding.FragmentBrowserBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class BrowserFragment : Fragment(R.layout.fragment_browser) {
    private val binding by viewBinding(FragmentBrowserBinding::bind)
    private val args by navArgs<BrowserFragmentArgs>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.webBrowser.webViewClient = WebClient()
        binding.webBrowser.settings.apply {
            javaScriptEnabled = true
            setSupportZoom(true)
            displayZoomControls =true

        }

        binding.webBrowser.loadUrl(args.url)

    }


    inner class WebClient : WebViewClient(){

        override fun shouldOverrideUrlLoading(
            view: WebView?,
            request: WebResourceRequest?
        ): Boolean {
            request?.url?.let {
                view?.loadUrl(it.toString())

            }
            return true
        }
    }

}