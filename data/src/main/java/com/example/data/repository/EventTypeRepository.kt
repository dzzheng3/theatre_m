package com.example.data.repository

import com.example.data.local.EventTypeLocalDataSource
import com.example.data.local.model.EventTypeLocalModel
import com.example.data.remote.EventTypeRemoteDataSource
import com.example.data.repository.mapper.EventTypeMapper
import io.reactivex.Observable

class EventTypeRepository(
    private val eventTypeLocalDataSource: EventTypeLocalDataSource,
    private val eventTypeRemoteDataSource: EventTypeRemoteDataSource,
    private val eventTypeMapper: EventTypeMapper
) {

    fun getAll(): Observable<List<EventTypeLocalModel>> {
        val local = eventTypeLocalDataSource.getAll().filter { !it.isEmpty() }
        val remote = eventTypeRemoteDataSource.getAll().map { eventTypeMapper.toLocal(it) }
            .doOnNext { eventTypeLocalDataSource.insertAll(it) }
        return Observable.concat(local, remote).firstElement().toObservable()
    }

    fun getById(id: Int): Observable<EventTypeLocalModel> = eventTypeLocalDataSource.getById(id)
}