package com.christianfoulcard.mediflare.utils

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class DateUtil {

    fun Date?.toFormattedString(): String {
        if (this == null) return "N/A"
        val sdf = SimpleDateFormat("dd-MM-yyyy", Locale.getDefault())
        return sdf.format(this)
    }
}