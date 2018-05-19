package com.example.data.mapper

import com.example.data.local.model.EventTypeLocalModel
import com.example.domain.entity.EventType

class SystemMapper {
    fun toEntity(eventTypeLocalModel: EventTypeLocalModel) = EventType(eventTypeLocalModel.id, eventTypeLocalModel.name)
}