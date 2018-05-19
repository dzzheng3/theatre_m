package com.example.domain.gateway

import com.example.domain.entity.EventType
import io.reactivex.Observable

interface SystemGateway {
    fun getEventTypes(): Observable<List<EventType>>
}