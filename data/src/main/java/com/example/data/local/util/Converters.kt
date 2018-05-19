package com.example.data.local.util

import android.arch.persistence.room.TypeConverter
import java.util.Date

class Converters {
    @TypeConverter
    fun timestampToDate(value: Long?): Date? = if (value == null) null else Date(value)

    @TypeConverter
    fun dateToTimestamp(date: Date?): Long? = date?.time
}