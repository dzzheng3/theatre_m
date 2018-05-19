package com.example.domain.interactor

import com.example.domain.Schedulers
import com.example.domain.UseCase
import com.example.domain.entity.EventType
import com.example.domain.gateway.SystemGateway
import io.reactivex.Observable

class EventTypeGetAllUseCase(schedulers: Schedulers, private val systemGateway: SystemGateway) :
    UseCase<Void, List<EventType>>(schedulers) {
    override fun buildObservalble(params: Void?): Observable<List<EventType>> {
        return systemGateway.getEventTypes()
    }
}