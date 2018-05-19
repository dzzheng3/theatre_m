package com.example.data.gateway

import com.example.data.mapper.SystemMapper
import com.example.data.repository.EventTypeRepository
import com.example.domain.entity.EventType
import com.example.domain.gateway.SystemGateway
import io.reactivex.Observable

class SystemGatewayImpl(private val eventTypeRepository: EventTypeRepository) : SystemGateway {
    private val mapper = SystemMapper()
    override fun getEventTypes(): Observable<List<EventType>> = eventTypeRepository.getAll()
        .doOnError { println("EventType Error") }.map {
            it.map { mapper.toEntity(it) }
        }
}