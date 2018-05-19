package com.example.data.local

import com.example.data.local.dao.EventTypeDao
import com.example.data.local.model.EventTypeLocalModel
import io.reactivex.Observable

class EventTypeLocalDataSource(private val eventTypeDao: EventTypeDao) {
    fun getAll(): Observable<List<EventTypeLocalModel>> = eventTypeDao.getAll().toObservable()
    fun insertAll(events: List<EventTypeLocalModel>) = eventTypeDao.insertAll(*events.toTypedArray())
    fun getById(id: Int): Observable<EventTypeLocalModel> = eventTypeDao.getById(id).toObservable()
}