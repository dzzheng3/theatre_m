/*
 * Copyright (c) 2018. André Mion
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.data.gateway

import com.example.data.gateway.mapper.InventoryMapper
import com.example.data.repository.EventRepository
import com.example.data.repository.EventTypeRepository
import com.example.data.repository.RatingRepository
import com.example.data.repository.VenueRepository
import com.example.domain.entity.Event
import com.example.domain.entity.Rating
import com.example.domain.entity.Venue
import com.example.domain.gateway.InventoryGateway
import io.reactivex.Observable

class InventoryGatewayImpl(
    private val eventTypeRepository: EventTypeRepository,
    private val eventRepository: EventRepository,
    private val venueRepository: VenueRepository,
    private val ratingRepository: RatingRepository
) : InventoryGateway {

    private val mapper = InventoryMapper()

    override fun findEventsByType(type: Int, refresh: Boolean): Observable<List<Event>> =

        eventRepository.findByType(type, refresh)
            .doOnError { println("Event By Type($type) Error") }
            .map { it.map { mapper.toEntity(it) } }

    override fun getVenueById(id: Int): Observable<Venue> =

        venueRepository.getById(id)
            .doOnError { println("Venue By Id($id) Error") }
            .map { mapper.toEntity(it) }

    override fun getEventById(id: Int): Observable<Event> =

        eventRepository.getById(id)
            .doOnError { println("Event By Id($id) Error") }
            .flatMap { event ->
                eventTypeRepository.getById(event.type)
                    .doOnError { println("Event Type By Id(${event.type}) Error") }
                    .map { mapper.toEntity(event) }
            }

    override fun findRatingByEvent(event: Int, refresh: Boolean): Observable<Rating> =

        ratingRepository.findByEvent(event, refresh)
            .doOnError { println("Rating By Event($event) Error") }
            .map { mapper.toEntity(it) }
}
