package com.example.data.remote

import com.example.data.remote.api.TheatreService
import com.example.data.remote.model.EventTypeRemoteModel
import io.reactivex.Observable

class EventTypeRemoteDataSource(private val theatreService: TheatreService) {
    fun getAll(): Observable<List<EventTypeRemoteModel>> = theatreService.getEventTypes()
}