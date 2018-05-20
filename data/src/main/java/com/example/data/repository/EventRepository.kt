package com.example.data.repository

import com.example.data.local.EventLocalDataSource
import com.example.data.local.model.EventLocalModel
import com.example.data.remote.EventRemoteDataSource
import com.example.data.repository.mapper.EventMapper
import io.reactivex.Observable

class EventRepository(
    private val eventLocalDataSource: EventLocalDataSource,
    private val eventRemoteDataSource: EventRemoteDataSource,
    private val eventMapper: EventMapper
) {
    fun findByType(type: Int, refresh: Boolean = false): Observable<List<EventLocalModel>> {
        val local = eventLocalDataSource.findByType(type).filter { !it.isEmpty() }
        val remote = eventRemoteDataSource.findByType(type)
            .map { eventMapper.toLocal(it) }
            .doOnNext { eventLocalDataSource.insertAll(it) }
        return Observable.just(refresh)
            .doOnNext { if (it) eventLocalDataSource.deleteByType(type) }
            .flatMap {
                Observable.concat(local, remote)
                    .firstElement()
                    .toObservable()
            }
    }

    fun getById(id: Int): Observable<EventLocalModel> {

        val local = eventLocalDataSource.getById(id)

        val remote = eventRemoteDataSource.getById(id)
            .map { eventMapper.toLocal(it) }
            .doOnNext { eventLocalDataSource.insert(it) }

        return Observable.concat(local, remote)
            .firstElement()
            .toObservable()
    }
}