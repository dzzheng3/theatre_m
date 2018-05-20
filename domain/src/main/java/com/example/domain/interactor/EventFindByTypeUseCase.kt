package com.example.domain.interactor

import com.example.domain.MissingUseCaseParameterException
import com.example.domain.Schedulers
import com.example.domain.UseCase
import com.example.domain.entity.Event
import com.example.domain.gateway.InventoryGateway
import io.reactivex.Observable

class EventFindByTypeUseCase(schedulers: Schedulers, private val inventoryGateway: InventoryGateway) :
    UseCase<Pair<Int, Boolean>, List<Event>>(schedulers) {
    override fun buildObservalble(params: Pair<Int, Boolean>?): Observable<List<Event>> {
        if (params == null) throw MissingUseCaseParameterException(javaClass)
        val (type, refresh) = params
        return inventoryGateway.findEventsByType(type, refresh)
    }
}