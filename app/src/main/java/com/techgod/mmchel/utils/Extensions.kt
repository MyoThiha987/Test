package com.techgod.mmchel.utils

import java.text.SimpleDateFormat
import java.util.*

private lateinit var simpleDateFormat:SimpleDateFormat

fun Date?.toDateStandard(): String {
    val pattern = "dd MMMM yyyy"
    return dateAsString(this, pattern)
}

fun Date?.toTimeStandardIn12Hours(): String {
    val pattern = "h:mm:ss a"
    return dateAsString(this, pattern)
}

private fun dateAsString(date: Date?, pattern: String): String {
    simpleDateFormat = SimpleDateFormat(pattern, Locale.getDefault())
    if (date != null)
        return simpleDateFormat.format(date)
    else
        throw NullPointerException("Date can't be null")
}