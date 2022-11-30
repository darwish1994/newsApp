package com.link.newsapp.common.extention

import java.text.SimpleDateFormat
import java.util.*


const val timeFormat = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'"
const val dayFormat = "MMM dd,yyyy"

fun Date.convertDateToString(): String {
    val sdf = SimpleDateFormat(dayFormat, Locale.getDefault())
    return sdf.format(this)
}
