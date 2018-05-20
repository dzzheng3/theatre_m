package com.example.domain.gateway

import com.example.domain.entity.Event
import io.reactivex.Observable

interface InventoryGateway {
    fun findEventsByType(type: Int, refresh: Boolean = false): Observable<List<Event>>
}