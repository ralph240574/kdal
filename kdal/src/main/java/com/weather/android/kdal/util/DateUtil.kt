package com.weather.android.kdal.util

import java.text.DateFormat
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*
import java.util.regex.Pattern


val NO_OFFSET = "+00:00"

/**
 * Parses a sign plus offset string in this exact format: "hh:mm", where hh (hours) are 00-24 and mm (minutes) are 00-59. (Including -00:00 which is not
 * technically legal ISO8601)
 */
val HHMM_PATTERN = Pattern.compile(".*([+-]([01]\\d|2[0-4]):?[0-5]\\d)$")

/**
 * Extract time zone offset from an ISO 8601 date string.
 *
 * @param dateString A date in ISO 8601 format, ending either in Z or in a time offset from UTC as hh:mm, where hh (hours) are 00-24 and mm (minutes) are
 * 00-59.
 * @return a 6-character time offset string (hh:mm) from GMT derived from the given date string. If no offset string was extractable from the given string
 * for any reason, returns "+00:00". Never returns `null` .
 */
fun String?.getTimeOffset(): String {
    if (this == null) {
        return NO_OFFSET
    }
    if (length >= 6) {
        val matcher = HHMM_PATTERN.matcher(substring(length - 6))
        if (matcher.matches()) {
            return matcher.group(1)
        }
    }
    return NO_OFFSET
}


val dateFormat = "yyyy-MM-dd'T'HH:mm:ssZZ"

val parser: ThreadLocal<DateFormat> = object : ThreadLocal<DateFormat>() {
    override fun initialValue(): DateFormat {
        return SimpleDateFormat(dateFormat, Locale.US)
    }
}

fun String.toDate(): Date? {
    try {
        return parser.get().parse(this)
    } catch (e: ParseException) {
        return null
    }
}


private val HHmm = SimpleDateFormat("HH:mm", Locale.US)

private val hhmma = SimpleDateFormat("hh:mm a", Locale.US)

fun Date.formatHHmm(timeOffset: String, use24hr: Boolean = false): String {
    val timeZone = TimeZone.getTimeZone("GMT${timeOffset}")
    if (use24hr) {
        HHmm.timeZone = timeZone
        return HHmm.format(this)
    } else {
        hhmma.timeZone = timeZone
        return hhmma.format(this)
    }
}

fun String.formatHHmm(use24hr: Boolean = false): String? {
    return toDate()?.formatHHmm(getTimeOffset(), use24hr)
}




