package com.link.newsapp.common.extention

import android.content.Context
import android.widget.Toast
import androidx.annotation.StringRes

fun Context.showToast(@StringRes msg:Int){
    Toast.makeText(this,msg, Toast.LENGTH_LONG).show()
}