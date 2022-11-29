package com.link.newsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.link.newsapp.common.extention.viewBinding
import com.link.newsapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val bindings by viewBinding(ActivityMainBinding::inflate)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(bindings.root)



    }
}