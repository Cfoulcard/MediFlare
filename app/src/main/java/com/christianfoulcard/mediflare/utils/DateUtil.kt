package com.christianfoulcard.mediflare.utils

import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale
import java.util.Random

class DateUtil {

    private val randomNumber = Random().nextInt(56) + 5
    private val calendar: Calendar = Calendar.getInstance()

    fun formatDate(date: Date?): String? {
        val format = SimpleDateFormat("M/d/yy 'at' h:mma", Locale.US)
        return date?.let { format.format(it) }
    }


    fun randomDateFromToday(): Date {
        val today = calendar.time
        calendar.set(Calendar.MONTH, Calendar.DECEMBER)
        calendar.set(Calendar.DAY_OF_MONTH, 31)
        val endOfYear = calendar.time
        return randomDate(today, endOfYear)
    }

    fun randomDateFromTodayPlusXMinutes(): Date {
        val date = randomDateFromToday()
        calendar.time = date
        calendar.add(Calendar.MINUTE, randomNumber)
        return calendar.time
    }

    fun randomDate(startDate: Date, endDate: Date): Date {
        val startMillis = startDate.time
        val endMillis = endDate.time
        val randomMillis = (startMillis + (Math.random() * (endMillis - startMillis))).toLong()
        return Date(randomMillis)
    }
}