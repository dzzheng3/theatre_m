package com.example.domain.gateway

import com.example.domain.entity.Event
import com.example.domain.entity.Rating
import com.example.domain.entity.Venue
import io.reactivex.Observable

interface InventoryGateway {

    fun findEventsByType(type: Int, refresh: Boolean = false): Observable<List<Event>>

    fun getVenueById(id: Int): Observable<Venue>

    fun getEventById(id: Int): Observable<Event>

    fun findRatingByEvent(event: Int, refresh: Boolean = false): Observable<Rating>
}