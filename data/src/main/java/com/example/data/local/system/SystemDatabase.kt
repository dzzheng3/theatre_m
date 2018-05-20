package com.example.data.local.system

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.arch.persistence.room.TypeConverters
import android.content.Context
import com.example.data.local.dao.EventTypeDao
import com.example.data.local.dao.VenueDao
import com.example.data.local.model.EventTypeLocalModel
import com.example.data.local.model.VenueLocalModel
import com.example.data.local.util.Converters

@Database(entities = [EventTypeLocalModel::class, VenueLocalModel::class], version = 1, exportSchema = false)
@TypeConverters(Converters::class)
abstract class SystemDatabase : RoomDatabase() {
    companion object {
        fun newInstance(context: Context): SystemDatabase {
            return Room.databaseBuilder(context, SystemDatabase::class.java, "theatre-system.db").build()
        }
    }

    abstract fun eventTypeDao(): EventTypeDao
    abstract fun venueDao(): VenueDao
}