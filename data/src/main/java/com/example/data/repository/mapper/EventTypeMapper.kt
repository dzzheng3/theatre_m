package com.example.data.repository.mapper

import com.example.data.local.model.EventTypeLocalModel
import com.example.data.remote.model.EventTypeRemoteModel

class EventTypeMapper {
    fun toLocal(eventTypeRemoteModel: EventTypeRemoteModel) = EventTypeLocalModel(eventTypeRemoteModel.id, eventTypeRemoteModel.name)
    fun toLocal(eventTypeRemoteModels: List<EventTypeRemoteModel>) = eventTypeRemoteModels.map { toLocal(it) }
}