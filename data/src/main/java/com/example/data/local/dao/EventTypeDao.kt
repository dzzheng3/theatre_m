package com.example.data.local.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import com.example.data.local.model.EventTypeLocalModel
import io.reactivex.Maybe

@Dao
interface EventTypeDao {
    @Query("select * from EventType where id = :id")
    fun getById(id: Int): Maybe<EventTypeLocalModel>

    @Query("select * from EventType")
    fun getAll(): Maybe<List<EventTypeLocalModel>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(vararg eventTypes: EventTypeLocalModel)
}