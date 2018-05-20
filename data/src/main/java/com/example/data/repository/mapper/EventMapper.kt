package com.example.data.repository.mapper

import com.example.data.local.model.EventLocalModel
import com.example.data.remote.model.EventRemoteModel

class EventMapper {
    fun toLocal(event: EventRemoteModel) = EventLocalModel(event.id, event.type, event.name, event.description, event.venue, event.runningTime, event.tagLine,
        event.image, event.thumbnail, event.url, event.currentPrice, event.offerPrice, event.minimumPrice)

    fun toLocal(events: List<EventRemoteModel>) = events.map { toLocal(it) }
}