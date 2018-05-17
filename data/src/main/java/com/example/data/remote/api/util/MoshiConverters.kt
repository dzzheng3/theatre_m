package com.example.data.remote.api.util

import com.squareup.moshi.FromJson
import com.squareup.moshi.ToJson
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class MoshiConverters {
    private val format = SimpleDateFormat("yyyy-MM-dd'T'HH::mm:ss.sss", Locale.getDefault())
    @FromJson
    fun timestampToDate(value: String?): Date? = format.parse(value)

    @ToJson
    fun dateToTimestamp(date: Date?): String? = date?.let { format.format(date) }
}