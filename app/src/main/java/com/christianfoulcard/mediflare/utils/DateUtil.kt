package com.christianfoulcard.mediflare.utils

import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale
import java.util.Random

class DateUtil {

    private val randomNumber = Random().nextInt(56) + 5
    private val calendar: Calendar = Calendar.getInstance()

    /**
     * Formats a given date into a string with the format "M/d/yy 'at' h:mma" (e.g., "9/7/23 at 3:30PM").
     *
     * @param date The date to be formatted.
     * @return A formatted date string or null if the input date is null.
     */
    fun formatDate(date: Date?): String? {
        val format = SimpleDateFormat("M/d/yy 'at' h:mma", Locale.US)
        return date?.let { format.format(it) }
    }

    /**
     * Generates and returns a random date between today and December 31st of the current year.
     *
     * @return A random date within the specified range.
     */
    fun randomDateFromToday(): Date {
        val today = calendar.time
        calendar.set(Calendar.MONTH, Calendar.DECEMBER)
        calendar.set(Calendar.DAY_OF_MONTH, 31)
        val endOfYear = calendar.time
        return randomDate(today, endOfYear)
    }

    /**
     * Generates and returns a random date within a range starting from today and extending by a random number
     * of minutes (specified by `randomNumber`).
     *
     * @return A random date within the specified range.
     */
    fun randomDateFromTodayPlusXMinutes(): Date {
        val date = randomDateFromToday()
        calendar.time = date
        calendar.add(Calendar.MINUTE, randomNumber)
        return calendar.time
    }

    /**
     * Generates and returns a random date within a specified range.
     *
     * @param startDate The start date of the range.
     * @param endDate   The end date of the range.
     * @return A random date within the specified range.
     */
    private fun randomDate(startDate: Date, endDate: Date): Date {
        val startMillis = startDate.time
        val endMillis = endDate.time
        val randomMillis = (startMillis + (Math.random() * (endMillis - startMillis))).toLong()
        return Date(randomMillis)
    }
}